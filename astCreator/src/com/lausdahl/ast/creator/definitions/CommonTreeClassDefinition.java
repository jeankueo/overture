package com.lausdahl.ast.creator.definitions;

import org.antlr.runtime.tree.CommonTree;

import com.lausdahl.ast.creator.Environment;
import com.lausdahl.ast.creator.methods.CloneMethod;
import com.lausdahl.ast.creator.methods.CloneWithMapMethod;
import com.lausdahl.ast.creator.methods.ConstructorMethod;
import com.lausdahl.ast.creator.methods.DefaultConstructorMethod;
import com.lausdahl.ast.creator.methods.GetMethod;
import com.lausdahl.ast.creator.methods.KindMethod;
import com.lausdahl.ast.creator.methods.KindNodeMethod;
import com.lausdahl.ast.creator.methods.Method;
import com.lausdahl.ast.creator.methods.RemoveChildMethod;
import com.lausdahl.ast.creator.methods.SetMethod;
import com.lausdahl.ast.creator.methods.ToStringMethod;

public class CommonTreeClassDefinition extends BaseClassDefinition implements
		IClassDefinition
{
	// public static final List<CommonTreeClassDefinition> classes = new Vector<CommonTreeClassDefinition>();
	Environment env;

	private ClassType type = ClassType.Alternative;
//	public IClassDefinition superClass;
	public CommonTree thisClass;

	public CommonTreeClassDefinition(CommonTree thisClass,
			IClassDefinition superClass, ClassType type, Environment env)
	{
		super(null);

		this.thisClass = thisClass;
		setSuperClass(superClass);

		this.type = type;
		this.env = env;
		super.name = getName();

		if (type != ClassType.Production /* && !fields.isEmpty() */)
		{
			methods.add(new ConstructorMethod(this, env));
			if (type != ClassType.Token)
			{
				methods.add(new DefaultConstructorMethod(this, env));
			}
		}

		if (type != ClassType.Token)
		{
			methods.add(new RemoveChildMethod(this, fields, env));
		}

		methods.add(new ToStringMethod(this, env));

		if (this.type != ClassType.Production)
		{
			methods.add(new CloneMethod(this, type, env));
			methods.add(new CloneWithMapMethod(this, type, env));
		}

		if (this.type == ClassType.Production)
		{
			methods.add(new KindNodeMethod(this, env));
		}

		if (this.type != ClassType.Token)
		{
			methods.add(new KindMethod(this, env));
		}

		env.addClass(this);
	}

	public void setSuperClass(IClassDefinition superClass)
	{
		this.superDef = superClass;
		if (superClass != null)
		{
			setPackageName(this.superDef.getPackageName());
			imports.add(this.superDef);
		}
	}

	public ClassType getType()
	{
		return this.type;
	}

	public String getName()
	{
		if (thisClass != null)
		{
			String name = firstLetterUpper(thisClass.getText());
			switch (type)
			{
				case Alternative:
					name = "A" + name+getSuperClassDefinition().getName().substring(1);
					break;
				case Production:
					name = "P" + name;
					break;
				case Token:
					name = "T" + name;
					break;
			}

//			if (getSuperClassDefinition() != null)
//			{
//				name += getSuperClassDefinition().getName();//getSuperName().substring(1);
//			}
			String tmp = javaClassName(name.replace(namePostfix, "")+namePostfix);
			if (VDM && tmp.contains("."))
			{
				return tmp.substring(tmp.lastIndexOf('.') + 1);
			} else
			{
				return tmp;
			}
		}
		return null;
	}

//	public String getSuperName()
//	{
//		switch (type)
//		{
//			case Alternative:
//				if (getSuperClassDefinition() != null)
//				{
//					return getSuperClassDefinition().getName();
//				}
//				break;
//			case Production:
//				return "Node";
//
//			case Token:
//				return "Token";
//
//			default:
//				return "Node";
//
//		}
//
//		return null;
//	}

	@Override
	public boolean isAbstract()
	{
		return type == ClassType.Production;
	}

	@Override
	public boolean isFinal()
	{
		return type == ClassType.Token;
	}

	
	@Override
	public IClassDefinition getSuperDef()
	{
		return getSuperClassDefinition();
	}
	public IClassDefinition getSuperClassDefinition()
	{
		switch (type)
		{
			case Alternative:
				if (superDef != null)
				{
					return superDef;
				}
				break;
			case Production:
				return env.node;

			case Token:
				return env.token;

			default:
				return env.node;

		}
		return superDef;
	}

	@Override
	public void addField(Field field)
	{
		super.addField(field);
		Method setM = new SetMethod(this, field, env);
		methods.add(setM);

		Method getM = new GetMethod(this, field, env);
		methods.add(getM);

	}

	@Override
	public boolean hasSuper()
	{
		return true;// this.getSuperClassDefinition() != null;
	}

	public String getEnumName()
	{
		return javaClassName(thisClass.getText()).toUpperCase();
	}

	public String getEnumTypeName()
	{
		return "E" + BaseClassDefinition.firstLetterUpper(thisClass.getText())+namePostfix;
	}
	@Override
	public String getPackageName()
	{
	switch (type)
	{
		case Production:
			return super.getPackageName();
		case Alternative:
			return getSuperDef().getPackageName();
		case Custom:
		
		case Token:
		case Unknown:

		default:
			break;
	}
	return super.getPackageName();
	}
}
