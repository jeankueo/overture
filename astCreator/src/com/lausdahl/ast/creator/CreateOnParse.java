package com.lausdahl.ast.creator;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;

import com.lausdahl.ast.creator.definitions.BaseClassDefinition;
import com.lausdahl.ast.creator.definitions.CommonTreeClassDefinition;
import com.lausdahl.ast.creator.definitions.ExternalJavaClassDefinition;
import com.lausdahl.ast.creator.definitions.Field;
import com.lausdahl.ast.creator.definitions.IClassDefinition;
import com.lausdahl.ast.creator.methods.Method;
import com.lausdahl.ast.creator.methods.TokenConstructorMethod;
import com.lausdahl.ast.creator.parser.AstcLexer;
import com.lausdahl.ast.creator.parser.AstcParser;

public class CreateOnParse
{
	public Environment parse(String astFile, String defaultPackage)
			throws IOException
	{
		Environment env = new Environment(defaultPackage);

		ANTLRFileStream input = new ANTLRFileStream(astFile);
		AstcLexer lexer = new AstcLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		AstcParser parser = new AstcParser(tokens);

		try
		{
			AstcParser.root_return result = parser.root();
			CommonTree t = (CommonTree) result.getTree();

			show(t, 0);
			for (Object root : t.getChildren())
			{
				if (root instanceof CommonTree)
				{
					CommonTree node = (CommonTree) root;
					if (node.getText().equals("Abstract Syntax Tree"))
					{
						for (Object production : node.getChildren())
						{
							if (production instanceof CommonTree)
							{
								CommonTree p = (CommonTree) production;
								CommonTreeClassDefinition c = new CommonTreeClassDefinition(p, null, CommonTreeClassDefinition.ClassType.Production, env);
								c.setPackageName(defaultPackage);
								for (Object a : p.getChildren())
								{
									if (a instanceof CommonTree)
									{
										CommonTree aa = (CommonTree) a;

										if (aa.getText() != null
												&& aa.getText().equals("->"))
										{
											for (Object o : aa.getChildren())
											{
												if (o instanceof CommonTree
														&& ((CommonTree) o).getChildCount() > 0)
												{
													CommonTree oo = (CommonTree) o;
													if (oo.getText().equals("package"))
													{
														String packageName = oo.getChild(0).getText();
														c.setPackageName(packageName);
													}
												}
											}
										} else
										{
											exstractA(c, aa, env, defaultPackage);
										}
									}
								}
							}
						}
					} else if (node.getText().equals("Tokens"))
					{
						for (Object toke : node.getChildren())
						{
							if (toke instanceof CommonTree)
							{
								CommonTree p = (CommonTree) toke;
								CommonTree idT = null;
								boolean externalJavaType = false;
								if (p.getChildCount() > 0)
								{
									idT = (CommonTree) p.getChild(0);
									if (p.getChildCount() > 1)
									{
										if (p.getChild(0).getText().equals("java"))
										{
											externalJavaType = true;
											idT = (CommonTree) p.getChild(2);
										}
									}
								}

								CommonTreeClassDefinition c = null;
								if (!externalJavaType)
								{
									c = new CommonTreeClassDefinition(p, null, CommonTreeClassDefinition.ClassType.Token, env);
									c.setPackageName(defaultPackage+".tokens");
								} else
								{
									c = new ExternalJavaClassDefinition(p, null, CommonTreeClassDefinition.ClassType.Token, idT.getText(), env);
								}

								c.imports.add(env.token);
								c.imports.add(env.node);
								Field f = new Field(env);
								f.name = "text";
								f.type = env.stringDef;
								f.isTokenField = true;
								c.addField(f);
								Method m = new TokenConstructorMethod(c, f, idT.getText(), env);
								c.methods.add(m);
								System.out.println("Token: " + p);
							}
						}
					} else if (node.getText().equals("Aspect Declaration"))
					{
						for (Object toke : node.getChildren())
						{
							if (toke instanceof CommonTree)
							{
								CommonTree p = (CommonTree) toke;
								String classDefName = "P"
										+ BaseClassDefinition.firstLetterUpper(p.getText());
								IClassDefinition c = env.lookUp(classDefName);

								if (p.getChildCount() > 0)
								{
									for (Object aspectDcl : p.getChildren())
									{
										if (aspectDcl instanceof CommonTree)
										{
											CommonTree aspectDclT = (CommonTree) aspectDcl;
											Field f = new Field(env);

											if (aspectDclT.getChildCount() > 0)
											{
												for (Object aspectDclName : p.getChildren())
												{
													if (aspectDclName instanceof CommonTree)
													{
														CommonTree aspectDclNameT = (CommonTree) aspectDclName;
														f.name = aspectDclNameT.getText();
													}
												}
											}
											f.isAspect = true;
											f.setType(aspectDclT.getText());
											c.addField(f);
										}
									}

								}

								System.out.println("Aspect Decleration: " + p);
							}
						}
					}
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return env;
	}

	private static void exstractA(CommonTreeClassDefinition superClass,
			CommonTree a, Environment env, String defaultPackage)
	{
		CommonTreeClassDefinition c = new CommonTreeClassDefinition(a, superClass, CommonTreeClassDefinition.ClassType.Alternative, env);
		c.setPackageName(defaultPackage);
		if (a.getChildCount() > 0)
		{
			for (Object f : a.getChildren())
			{
				if (f instanceof CommonTree)
				{
					CommonTree fTree = (CommonTree) f;
					Field field = new Field(env);
					String typeName = fTree.getText();

					if (fTree.getChild(0) != null)
					{
						field.name = fTree.getChild(0).getText();
					}
					if (fTree.getChildCount() > 1)
					{
						if (fTree.getChild(1) != null)
						{
							String regex = fTree.getChild(1).getText();
							if (regex.trim().equals("*"))
							{
								field.isList = true;
							}
						}
					}

					for (IClassDefinition cl : env.getClasses())
					{
						if (cl instanceof ExternalJavaClassDefinition
								&& ((ExternalJavaClassDefinition) cl).thisClass.getText().equals(typeName))
						{
							field.isTokenField = true;
							field.type = cl;// TODO
						}
					}
					if (field.type == null)
					{
						field.setType(typeName);
					}
					c.addField(field);

				}
			}
		}
	}

	public static void show(CommonTree token, int level)
	{
		String indent = "";
		for (int i = 0; i < level; i++)
		{
			indent += "  ";
		}

		System.out.println(indent + token.getText());
		if (token.getChildCount() > 0)
		{
			for (Object chld : token.getChildren())
			{
				if (chld instanceof CommonTree)
				{
					show((CommonTree) chld, level + 1);
				}
			}
		}
		if (level == 2)
			System.out.println();
	}
}
