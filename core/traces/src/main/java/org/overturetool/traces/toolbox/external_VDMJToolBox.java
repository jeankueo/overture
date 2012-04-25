//
// THIS FILE IS AUTOMATICALLY GENERATED!!
//
// Generated at 2009-05-25 by the VDM++ to JAVA Code Generator
// (v8.2b - Tue 19-May-2009 10:22:43)
//
// Supported compilers: jdk 1.4/1.5/1.6
//

// ***** VDMTOOLS START Name=HeaderComment KEEP=NO
// ***** VDMTOOLS END Name=HeaderComment

// ***** VDMTOOLS START Name=package KEEP=NO
package org.overturetool.traces.toolbox;

// ***** VDMTOOLS END Name=package

// ***** VDMTOOLS START Name=imports KEEP=YES

import jp.co.csk.vdm.toolbox.VDM.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

import org.overturetool.vdmj.definitions.ClassList;
import org.overturetool.vdmj.lex.Dialect;
import org.overturetool.vdmj.lex.LexTokenReader;
import org.overturetool.vdmj.runtime.ClassInterpreter;
import org.overturetool.vdmj.syntax.ClassReader;
import org.overturetool.vdmj.typechecker.ClassTypeChecker;
import org.overturetool.vdmj.typechecker.TypeChecker;
// ***** VDMTOOLS END Name=imports






public class external_VDMJToolBox {

// ***** VDMTOOLS START Name=parent KEEP=YES
	VDMJToolBox parent = null;
	ClassInterpreter interpreter = null;

// ***** VDMTOOLS END Name=parent


// ***** VDMTOOLS START Name=external_VDMJToolBox#1|VDMJToolBox KEEP=NO
  public external_VDMJToolBox (VDMJToolBox parentVDMJToolBox) {
    parent = parentVDMJToolBox;
  }
// ***** VDMTOOLS END Name=external_VDMJToolBox#1|VDMJToolBox


// ***** VDMTOOLS START Name=external_VDMJToolBox KEEP=NO
  public external_VDMJToolBox () {}
// ***** VDMTOOLS END Name=external_VDMJToolBox


// ***** VDMTOOLS START Name=impl_InitToolbox KEEP=YES
	public void impl_InitToolbox() throws CGException {
		int parsErrors = 0;
		ClassList classes = new ClassList();
		try {
			for (int i = 0; i < parent.specsFiles.size(); i++) {
				LexTokenReader ltr;

				ltr = new LexTokenReader(new File(parent.specsFiles.toArray()[i].toString()), Dialect.VDM_PP);

				ClassReader mr = new ClassReader(ltr);
				parsErrors += mr.getErrorCount();
				classes.addAll(mr.readClasses());
			}

			if (parsErrors == 0) {
				TypeChecker tc = new ClassTypeChecker(classes);
				tc.typeCheck();
				if (TypeChecker.getErrorCount() == 0) {
					interpreter = new ClassInterpreter(classes);


				}else
{
TypeChecker.printErrors(new PrintWriter(System.out));
}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

// ***** VDMTOOLS END Name=impl_InitToolbox


// ***** VDMTOOLS START Name=impl_runTestCase#2|String|Vector KEEP=YES
	public Vector impl_runTestCase(final String className,
			final Vector expressions) throws CGException {

		String[] expr = new String[expressions.size()];
		for (int i = 0; i < expressions.size(); i++) {
			expr[i] = expressions.toArray()[i].toString();
		}

		try {
			org.overturetool.vdmj.Settings.prechecks=true;
			org.overturetool.vdmj.Settings.postchecks=true;
			org.overturetool.vdmj.Settings.dynamictypechecks=true;
			interpreter.init(null);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//List<Object> res = interpreter.runtrace(className, expr);
throw new CGException("This trace execution of VDMJ is no longer supported.");
//		Vector iResult = new Vector();

//		for (int j = 0; j < res.size(); j++) {
//			boolean isError = false;
//			 if (res.size()-1==j && res.get(j).toString().startsWith("Error"))
//			 isError= true;
//			iResult.add(new ToolBox.InterpreterResult(!isError, res.get(j).toString()));
//		}
//		return iResult;

	}
// ***** VDMTOOLS END Name=impl_runTestCase#2|String|Vector


// ***** VDMTOOLS START Name=impl_runtrace#2|String|Vector KEEP=NO
  public Vector impl_runtrace (final String classname, final Vector statements) throws CGException {

    UTIL.RunTime("Run-Time Error:Preliminary runtrace has been called");
    return new Vector();
  }
// ***** VDMTOOLS END Name=impl_runtrace#2|String|Vector

}
;
