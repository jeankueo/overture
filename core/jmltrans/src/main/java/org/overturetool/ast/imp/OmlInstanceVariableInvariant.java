//
// THIS FILE IS AUTOMATICALLY GENERATED!!
//
// Generated at Wed 11-Jun-2008 by the VDM++ to JAVA Code Generator
// (v8.0.1b - Mon 28-Jan-2008 10:17:36)
//
// Supported compilers:
// jdk1.4
//

// ***** VDMTOOLS START Name=HeaderComment KEEP=NO
// ***** VDMTOOLS END Name=HeaderComment

// ***** VDMTOOLS START Name=package KEEP=NO
package org.overturetool.ast.imp;

// ***** VDMTOOLS END Name=package

// ***** VDMTOOLS START Name=imports KEEP=YES

import jp.co.csk.vdm.toolbox.VDM.*;
import java.util.*;
import org.overturetool.ast.itf.*;
@SuppressWarnings(all) 
// ***** VDMTOOLS END Name=imports



public class OmlInstanceVariableInvariant extends OmlInstanceVariableShape implements IOmlInstanceVariableInvariant {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=ivInvariant KEEP=NO
  private IOmlExpression ivInvariant = null;
// ***** VDMTOOLS END Name=ivInvariant


// ***** VDMTOOLS START Name=OmlInstanceVariableInvariant KEEP=NO
  public OmlInstanceVariableInvariant () throws CGException {
    try {
      ivInvariant = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=OmlInstanceVariableInvariant


// ***** VDMTOOLS START Name=identity KEEP=NO
  public String identity () throws CGException {
    return new String("InstanceVariableInvariant");
  }
// ***** VDMTOOLS END Name=identity


// ***** VDMTOOLS START Name=accept KEEP=NO
  public void accept (final IOmlVisitor pVisitor) throws CGException {
    pVisitor.visitInstanceVariableInvariant((IOmlInstanceVariableInvariant) this);
  }
// ***** VDMTOOLS END Name=accept


// ***** VDMTOOLS START Name=OmlInstanceVariableInvariant KEEP=NO
  public OmlInstanceVariableInvariant (final IOmlExpression p1) throws CGException {

    try {
      ivInvariant = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    setInvariant((IOmlExpression) p1);
  }
// ***** VDMTOOLS END Name=OmlInstanceVariableInvariant


// ***** VDMTOOLS START Name=OmlInstanceVariableInvariant KEEP=NO
  public OmlInstanceVariableInvariant (final IOmlExpression p1, final Long line, final Long column) throws CGException {

    try {
      ivInvariant = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    {

      setInvariant((IOmlExpression) p1);
      setPosition(line, column);
    }
  }
// ***** VDMTOOLS END Name=OmlInstanceVariableInvariant


// ***** VDMTOOLS START Name=init KEEP=NO
  public void init (final HashMap data) throws CGException {

    String fname = new String("invariant");
    Boolean cond_4 = null;
    cond_4 = new Boolean(data.containsKey(fname));
    if (cond_4.booleanValue()) 
      setInvariant((IOmlExpression) data.get(fname));
  }
// ***** VDMTOOLS END Name=init


// ***** VDMTOOLS START Name=getInvariant KEEP=NO
  public IOmlExpression getInvariant () throws CGException {
    return (IOmlExpression) ivInvariant;
  }
// ***** VDMTOOLS END Name=getInvariant


// ***** VDMTOOLS START Name=setInvariant KEEP=NO
  public void setInvariant (final IOmlExpression parg) throws CGException {
    ivInvariant = (IOmlExpression) UTIL.clone(parg);
  }
// ***** VDMTOOLS END Name=setInvariant

  public String toString() {
	  return this.ivInvariant.toString();
  }
}
;
