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



public class OmlBracketedType extends OmlType implements IOmlBracketedType {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=ivType KEEP=NO
  private IOmlType ivType = null;
// ***** VDMTOOLS END Name=ivType


// ***** VDMTOOLS START Name=OmlBracketedType KEEP=NO
  public OmlBracketedType () throws CGException {
    try {
      ivType = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=OmlBracketedType


// ***** VDMTOOLS START Name=identity KEEP=NO
  public String identity () throws CGException {
    return new String("BracketedType");
  }
// ***** VDMTOOLS END Name=identity


// ***** VDMTOOLS START Name=accept KEEP=NO
  public void accept (final IOmlVisitor pVisitor) throws CGException {
    pVisitor.visitBracketedType((IOmlBracketedType) this);
  }
// ***** VDMTOOLS END Name=accept


// ***** VDMTOOLS START Name=OmlBracketedType KEEP=NO
  public OmlBracketedType (final IOmlType p1) throws CGException {

    try {
      ivType = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    setType((IOmlType) p1);
  }
// ***** VDMTOOLS END Name=OmlBracketedType


// ***** VDMTOOLS START Name=OmlBracketedType KEEP=NO
  public OmlBracketedType (final IOmlType p1, final Long line, final Long column) throws CGException {

    try {
      ivType = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    {

      setType((IOmlType) p1);
      setPosition(line, column);
    }
  }
// ***** VDMTOOLS END Name=OmlBracketedType


// ***** VDMTOOLS START Name=init KEEP=NO
  public void init (final HashMap data) throws CGException {

    String fname = new String("type");
    Boolean cond_4 = null;
    cond_4 = new Boolean(data.containsKey(fname));
    if (cond_4.booleanValue()) 
      setType((IOmlType) data.get(fname));
  }
// ***** VDMTOOLS END Name=init


// ***** VDMTOOLS START Name=getType KEEP=NO
  public IOmlType getType () throws CGException {
    return (IOmlType) ivType;
  }
// ***** VDMTOOLS END Name=getType


// ***** VDMTOOLS START Name=setType KEEP=NO
  public void setType (final IOmlType parg) throws CGException {
    ivType = (IOmlType) UTIL.clone(parg);
  }
// ***** VDMTOOLS END Name=setType

}
;
