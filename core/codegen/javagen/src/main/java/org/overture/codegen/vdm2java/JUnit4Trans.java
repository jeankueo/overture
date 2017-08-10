package org.overture.codegen.vdm2java;

import org.apache.commons.lang.BooleanUtils;
import org.apache.log4j.Logger;
import org.overture.ast.util.ClonableString;
import org.overture.codegen.assistant.NodeAssistantIR;
import org.overture.codegen.ir.IRConstants;
import org.overture.codegen.ir.IRGeneratedTag;
import org.overture.codegen.ir.analysis.AnalysisException;
import org.overture.codegen.ir.analysis.DepthFirstAnalysisAdaptor;
import org.overture.codegen.ir.declarations.ADefaultClassDeclIR;
import org.overture.codegen.ir.declarations.AMethodDeclIR;
import org.overture.codegen.ir.declarations.SClassDeclIR;
import org.overture.codegen.trans.assistants.TransAssistantIR;

import java.util.LinkedList;
import java.util.List;

public class JUnit4Trans extends DepthFirstAnalysisAdaptor
{
	protected Logger log = Logger.getLogger(this.getClass().getName());

	private static final String TEST_NAME_PREFIX = "test";
	public static final String TEST_ANNOTATION = "@Test";
	public static final String JUNI4_IMPORT = "org.junit.*";

	public TransAssistantIR assist;
	private JavaCodeGen javaCg;

	private List<SClassDeclIR> classCopies;

	public JUnit4Trans(TransAssistantIR assist, JavaCodeGen javaCg)
	{
		this.assist = assist;
		this.javaCg = javaCg;
	}

	public ADefaultClassDeclIR findCopy(ADefaultClassDeclIR clazz)
	{
		for(SClassDeclIR c : classCopies)
		{
			if(c instanceof ADefaultClassDeclIR && c.getName().equals(clazz.getName()))
			{
				return (ADefaultClassDeclIR) c;
			}
		}

		return null;
	}

	@Override
	public void caseADefaultClassDeclIR(ADefaultClassDeclIR node)
			throws AnalysisException
	{
		if (!javaCg.getJavaSettings().genJUnit4tests())
		{
			return;
		}

		if(classCopies == null)
		{
			this.classCopies = new LinkedList<>();

			for(SClassDeclIR c : assist.getInfo().getClasses())
			{
				if(c instanceof ADefaultClassDeclIR)
				{
					this.classCopies.add((ADefaultClassDeclIR) c.clone());
				}
			}
		}

		// We need to analyse the copy, as the counterpart might have been modified
		ADefaultClassDeclIR copy = findCopy(node);

		if(copy == null)
		{
			log.error("Could not find copy of " + node.getName());
		}

		if (!assist.getInfo().getDeclAssistant().isTest(copy, classCopies))
		{
			return;
		}

		/**
		 * 1) Delete runFullSuite method with no parameters
		 */
		removeRunFullSuiteMethod(node);
		/**
		 * 2) Remove TestCase super class
		 */
		if(assist.getInfo().getDeclAssistant().parentIsTest(copy))
		{
			node.getSuperNames().clear();
		}

		/**
		 * 3) Import JUnit4
		 */
		importJunit4(node);
		/**
		 * 4) Add the '@Test' annotation to public non-static, non-constructor methods that take no arguements and start
		 * with 'test'
		 */
		addTestAnnotations(node);
	}

	public void addTestAnnotations(ADefaultClassDeclIR node)
	{
		NodeAssistantIR nodeAssist = assist.getInfo().getNodeAssistant();

		for (AMethodDeclIR m : node.getMethods())
		{
			if (m.getName().startsWith(TEST_NAME_PREFIX)
					&& m.getAccess().equals(IRConstants.PUBLIC)
					&& BooleanUtils.isFalse(m.getStatic())
					&& BooleanUtils.isFalse(m.getIsConstructor())
					&& m.getFormalParams().isEmpty()
					&& !(m.getTag() instanceof IRGeneratedTag))
			{
				nodeAssist.addMetaData(m, str2meta(TEST_ANNOTATION), false);
			}
		}
	}

	public void importJunit4(ADefaultClassDeclIR node)
	{
		assist.getInfo().getDeclAssistant().addDependencies(node, str2meta(JUNI4_IMPORT), false);
	}

	public void removeRunFullSuiteMethod(ADefaultClassDeclIR node)
	{
		for (int i = 0; i < node.getMethods().size(); i++)
		{
			AMethodDeclIR currentMethod = node.getMethods().get(i);

			if (currentMethod.getName().equals(IRConstants.TEST_CASE_RUN_FULL_SUITE)
					&& currentMethod.getFormalParams().isEmpty())
			{
				node.getMethods().remove(i);
				break;
			}
		}
	}

	public List<ClonableString> str2meta(String str)
	{
		List<ClonableString> extraMetaData = new LinkedList<>();

		extraMetaData.add(new ClonableString(str));
		return extraMetaData;
	}
}
