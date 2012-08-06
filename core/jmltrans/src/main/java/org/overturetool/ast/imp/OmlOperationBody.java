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



public class OmlOperationBody extends OmlNode implements IOmlOperationBody {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=ivStatement KEEP=NO
  private IOmlStatement ivStatement = null;
// ***** VDMTOOLS END Name=ivStatement

// ***** VDMTOOLS START Name=ivNotYetSpecified KEEP=NO
  private Boolean ivNotYetSpecified = null;
// ***** VDMTOOLS END Name=ivNotYetSpecified

// ***** VDMTOOLS START Name=ivSubclassResponsibility KEEP=NO
  private Boolean ivSubclassResponsibility = null;
// ***** VDMTOOLS END Name=ivSubclassResponsibility


// ***** VDMTOOLS START Name=OmlOperationBody KEEP=NO
  public OmlOperationBody () throws CGException {
    try {

      ivStatement = null;
      ivNotYetSpecified = null;
      ivSubclassResponsibility = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=OmlOperationBody


// ***** VDMTOOLS START Name=identity KEEP=NO
  public String identity () throws CGException {
    return new String("OperationBody");
  }
// ***** VDMTOOLS END Name=identity


// ***** VDMTOOLS START Name=accept KEEP=NO
  public void accept (final IOmlVisitor pVisitor) throws CGException {
    pVisitor.visitOperationBody((IOmlOperationBody) this);
  }
// ***** VDMTOOLS END Name=accept


// ***** VDMTOOLS START Name=OmlOperationBody KEEP=NO
  public OmlOperationBody (final IOmlStatement p1, final Boolean p2, final Boolean p3) throws CGException {

    try {

      ivStatement = null;
      ivNotYetSpecified = null;
      ivSubclassResponsibility = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    {

      setStatement((IOmlStatement) p1);
      setNotYetSpecified(p2);
      setSubclassResponsibility(p3);
    }
  }
// ***** VDMTOOLS END Name=OmlOperationBody


// ***** VDMTOOLS START Name=OmlOperationBody KEEP=NO
  public OmlOperationBody (final IOmlStatement p1, final Boolean p2, final Boolean p3, final Long line, final Long column) throws CGException {

    try {

      ivStatement = null;
      ivNotYetSpecified = null;
      ivSubclassResponsibility = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    {

      setStatement((IOmlStatement) p1);
      setNotYetSpecified(p2);
      setSubclassResponsibility(p3);
      setPosition(line, column);
    }
  }
// ***** VDMTOOLS END Name=OmlOperationBody


// ***** VDMTOOLS START Name=init KEEP=NO
  public void init (final HashMap data) throws CGException {

    {

      String fname = new String("statement");
      Boolean cond_4 = null;
      cond_4 = new Boolean(data.containsKey(fname));
      if (cond_4.booleanValue()) 
        setStatement((IOmlStatement) data.get(fname));
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


// ***** VDMTOOLS START Name=getStatement KEEP=NO
  public IOmlStatement getStatement () throws CGException {
    return (IOmlStatement) ivStatement;
  }
// ***** VDMTOOLS END Name=getStatement


// ***** VDMTOOLS START Name=hasStatement KEEP=NO
  public Boolean hasStatement () throws CGException {
    return new Boolean(!UTIL.equals(ivStatement, null));
  }
// ***** VDMTOOLS END Name=hasStatement


// ***** VDMTOOLS START Name=setStatement KEEP=NO
  public void setStatement (final IOmlStatement parg) throws CGException {
    ivStatement = (IOmlStatement) UTIL.clone(parg);
  }
// ***** VDMTOOLS END Name=setStatement


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

  public String toString() {
	  String res = new String();
	  try {
		if (hasStatement()) res = this.ivStatement.toString();
		  else if (this.ivNotYetSpecified) res = "is not yet specified";
		  else res = "is subclass responsibility";
	} catch (CGException e) {
		

		e.printStackTrace();
	}
	return res;
  }
}
;
