//
// THIS FILE IS AUTOMATICALLY GENERATED!!
//
// Generated at Sat 16-Aug-2008 by the VDM++ to JAVA Code Generator
// (v8.1.1b - Fri 06-Jun-2008 09:09:07)
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
@SuppressWarnings("all") 
// ***** VDMTOOLS END Name=imports



public class OmlFunctionBody extends OmlNode implements IOmlFunctionBody {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=ivFunctionBody KEEP=NO
  private IOmlExpression ivFunctionBody = null;
// ***** VDMTOOLS END Name=ivFunctionBody

// ***** VDMTOOLS START Name=ivNotYetSpecified KEEP=NO
  private Boolean ivNotYetSpecified = null;
// ***** VDMTOOLS END Name=ivNotYetSpecified

// ***** VDMTOOLS START Name=ivSubclassResponsibility KEEP=NO
  private Boolean ivSubclassResponsibility = null;
// ***** VDMTOOLS END Name=ivSubclassResponsibility


// ***** VDMTOOLS START Name=OmlFunctionBody KEEP=NO
  public OmlFunctionBody () throws CGException {
    try {

      ivFunctionBody = null;
      ivNotYetSpecified = null;
      ivSubclassResponsibility = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=OmlFunctionBody


// ***** VDMTOOLS START Name=identity KEEP=NO
  public String identity () throws CGException {
    return new String("FunctionBody");
  }
// ***** VDMTOOLS END Name=identity


// ***** VDMTOOLS START Name=accept KEEP=NO
  public void accept (final IOmlVisitor pVisitor) throws CGException {
    pVisitor.visitFunctionBody((IOmlFunctionBody) this);
  }
// ***** VDMTOOLS END Name=accept


// ***** VDMTOOLS START Name=OmlFunctionBody KEEP=NO
  public OmlFunctionBody (final IOmlExpression p1, final Boolean p2, final Boolean p3) throws CGException {

    try {

      ivFunctionBody = null;
      ivNotYetSpecified = null;
      ivSubclassResponsibility = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    {

      setFunctionBody((IOmlExpression) p1);
      setNotYetSpecified(p2);
      setSubclassResponsibility(p3);
    }
  }
// ***** VDMTOOLS END Name=OmlFunctionBody


// ***** VDMTOOLS START Name=OmlFunctionBody KEEP=NO
  public OmlFunctionBody (final IOmlExpression p1, final Boolean p2, final Boolean p3, final Long line, final Long column) throws CGException {

    try {

      ivFunctionBody = null;
      ivNotYetSpecified = null;
      ivSubclassResponsibility = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    {

      setFunctionBody((IOmlExpression) p1);
      setNotYetSpecified(p2);
      setSubclassResponsibility(p3);
      setPosition(line, column);
    }
  }
// ***** VDMTOOLS END Name=OmlFunctionBody


// ***** VDMTOOLS START Name=init KEEP=NO
  public void init (final HashMap data) throws CGException {

    {

      String fname = new String("function_body");
      Boolean cond_4 = null;
      cond_4 = new Boolean(data.containsKey(fname));
      if (cond_4.booleanValue()) 
        setFunctionBody((IOmlExpression) data.get(fname));
    }
    {

      String fname = new String("not_yet_specified");
      Boolean cond_13 = null;
      cond_13 = new Boolean(data.containsKey(fname));
      if (cond_13.booleanValue()) 
        setNotYetSpecified((Boolean) data.get(fname));
    }
    {

      String fname = new String("subclass_responsibility");
      Boolean cond_22 = null;
      cond_22 = new Boolean(data.containsKey(fname));
      if (cond_22.booleanValue()) 
        setSubclassResponsibility((Boolean) data.get(fname));
    }
  }
// ***** VDMTOOLS END Name=init


// ***** VDMTOOLS START Name=getFunctionBody KEEP=NO
  public IOmlExpression getFunctionBody () throws CGException {

    if (!this.pre_getFunctionBody().booleanValue()) 
      UTIL.RunTime("Run-Time Error:Precondition failure in getFunctionBody");
    return (IOmlExpression) ivFunctionBody;
  }
// ***** VDMTOOLS END Name=getFunctionBody


// ***** VDMTOOLS START Name=pre_getFunctionBody KEEP=NO
  public Boolean pre_getFunctionBody () throws CGException {
    return hasFunctionBody();
  }
// ***** VDMTOOLS END Name=pre_getFunctionBody


// ***** VDMTOOLS START Name=hasFunctionBody KEEP=NO
  public Boolean hasFunctionBody () throws CGException {
    return new Boolean(!UTIL.equals(ivFunctionBody, null));
  }
// ***** VDMTOOLS END Name=hasFunctionBody


// ***** VDMTOOLS START Name=setFunctionBody KEEP=NO
  public void setFunctionBody (final IOmlExpression parg) throws CGException {
    ivFunctionBody = (IOmlExpression) UTIL.clone(parg);
  }
// ***** VDMTOOLS END Name=setFunctionBody


// ***** VDMTOOLS START Name=getNotYetSpecified KEEP=NO
  public Boolean getNotYetSpecified () throws CGException {
    return ivNotYetSpecified;
  }
// ***** VDMTOOLS END Name=getNotYetSpecified


// ***** VDMTOOLS START Name=setNotYetSpecified KEEP=NO
  public void setNotYetSpecified (final Boolean parg) throws CGException {
    ivNotYetSpecified = (Boolean) UTIL.clone(parg);
  }
// ***** VDMTOOLS END Name=setNotYetSpecified


// ***** VDMTOOLS START Name=getSubclassResponsibility KEEP=NO
  public Boolean getSubclassResponsibility () throws CGException {
    return ivSubclassResponsibility;
  }
// ***** VDMTOOLS END Name=getSubclassResponsibility


// ***** VDMTOOLS START Name=setSubclassResponsibility KEEP=NO
  public void setSubclassResponsibility (final Boolean parg) throws CGException {
    ivSubclassResponsibility = (Boolean) UTIL.clone(parg);
  }
// ***** VDMTOOLS END Name=setSubclassResponsibility

}
;
