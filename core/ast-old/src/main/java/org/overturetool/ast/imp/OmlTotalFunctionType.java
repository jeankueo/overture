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



public class OmlTotalFunctionType extends OmlType implements IOmlTotalFunctionType {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=ivDomType KEEP=NO
  private IOmlType ivDomType = null;
// ***** VDMTOOLS END Name=ivDomType

// ***** VDMTOOLS START Name=ivRngType KEEP=NO
  private IOmlType ivRngType = null;
// ***** VDMTOOLS END Name=ivRngType


// ***** VDMTOOLS START Name=OmlTotalFunctionType KEEP=NO
  public OmlTotalFunctionType () throws CGException {
    try {

      ivDomType = null;
      ivRngType = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=OmlTotalFunctionType


// ***** VDMTOOLS START Name=identity KEEP=NO
  public String identity () throws CGException {
    return new String("TotalFunctionType");
  }
// ***** VDMTOOLS END Name=identity


// ***** VDMTOOLS START Name=accept KEEP=NO
  public void accept (final IOmlVisitor pVisitor) throws CGException {
    pVisitor.visitTotalFunctionType((IOmlTotalFunctionType) this);
  }
// ***** VDMTOOLS END Name=accept


// ***** VDMTOOLS START Name=OmlTotalFunctionType KEEP=NO
  public OmlTotalFunctionType (final IOmlType p1, final IOmlType p2) throws CGException {

    try {

      ivDomType = null;
      ivRngType = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    {

      setDomType((IOmlType) p1);
      setRngType((IOmlType) p2);
    }
  }
// ***** VDMTOOLS END Name=OmlTotalFunctionType


// ***** VDMTOOLS START Name=OmlTotalFunctionType KEEP=NO
  public OmlTotalFunctionType (final IOmlType p1, final IOmlType p2, final Long line, final Long column) throws CGException {

    try {

      ivDomType = null;
      ivRngType = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    {

      setDomType((IOmlType) p1);
      setRngType((IOmlType) p2);
      setPosition(line, column);
    }
  }
// ***** VDMTOOLS END Name=OmlTotalFunctionType


// ***** VDMTOOLS START Name=init KEEP=NO
  public void init (final HashMap data) throws CGException {

    {

      String fname = new String("dom_type");
      Boolean cond_4 = null;
      cond_4 = new Boolean(data.containsKey(fname));
      if (cond_4.booleanValue()) 
        setDomType((IOmlType) data.get(fname));
    }
    {

      String fname = new String("rng_type");
      Boolean cond_13 = null;
      cond_13 = new Boolean(data.containsKey(fname));
      if (cond_13.booleanValue()) 
        setRngType((IOmlType) data.get(fname));
    }
  }
// ***** VDMTOOLS END Name=init


// ***** VDMTOOLS START Name=getDomType KEEP=NO
  public IOmlType getDomType () throws CGException {
    return (IOmlType) ivDomType;
  }
// ***** VDMTOOLS END Name=getDomType


// ***** VDMTOOLS START Name=setDomType KEEP=NO
  public void setDomType (final IOmlType parg) throws CGException {
    ivDomType = (IOmlType) UTIL.clone(parg);
  }
// ***** VDMTOOLS END Name=setDomType


// ***** VDMTOOLS START Name=getRngType KEEP=NO
  public IOmlType getRngType () throws CGException {
    return (IOmlType) ivRngType;
  }
// ***** VDMTOOLS END Name=getRngType


// ***** VDMTOOLS START Name=setRngType KEEP=NO
  public void setRngType (final IOmlType parg) throws CGException {
    ivRngType = (IOmlType) UTIL.clone(parg);
  }
// ***** VDMTOOLS END Name=setRngType

}
;
