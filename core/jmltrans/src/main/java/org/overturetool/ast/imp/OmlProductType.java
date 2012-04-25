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



public class OmlProductType extends OmlType implements IOmlProductType {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=ivLhsType KEEP=NO
  private IOmlType ivLhsType = null;
// ***** VDMTOOLS END Name=ivLhsType

// ***** VDMTOOLS START Name=ivRhsType KEEP=NO
  private IOmlType ivRhsType = null;
// ***** VDMTOOLS END Name=ivRhsType


// ***** VDMTOOLS START Name=OmlProductType KEEP=NO
  public OmlProductType () throws CGException {
    try {

      ivLhsType = null;
      ivRhsType = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=OmlProductType


// ***** VDMTOOLS START Name=identity KEEP=NO
  public String identity () throws CGException {
    return new String("ProductType");
  }
// ***** VDMTOOLS END Name=identity


// ***** VDMTOOLS START Name=accept KEEP=NO
  public void accept (final IOmlVisitor pVisitor) throws CGException {
    pVisitor.visitProductType((IOmlProductType) this);
  }
// ***** VDMTOOLS END Name=accept


// ***** VDMTOOLS START Name=OmlProductType KEEP=NO
  public OmlProductType (final IOmlType p1, final IOmlType p2) throws CGException {

    try {

      ivLhsType = null;
      ivRhsType = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    {

      setLhsType((IOmlType) p1);
      setRhsType((IOmlType) p2);
    }
  }
// ***** VDMTOOLS END Name=OmlProductType


// ***** VDMTOOLS START Name=OmlProductType KEEP=NO
  public OmlProductType (final IOmlType p1, final IOmlType p2, final Long line, final Long column) throws CGException {

    try {

      ivLhsType = null;
      ivRhsType = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    {

      setLhsType((IOmlType) p1);
      setRhsType((IOmlType) p2);
      setPosition(line, column);
    }
  }
// ***** VDMTOOLS END Name=OmlProductType


// ***** VDMTOOLS START Name=init KEEP=NO
  public void init (final HashMap data) throws CGException {

    {

      String fname = new String("lhs_type");
      Boolean cond_4 = null;
      cond_4 = new Boolean(data.containsKey(fname));
      if (cond_4.booleanValue()) 
        setLhsType((IOmlType) data.get(fname));
    }
    {

      String fname = new String("rhs_type");
      Boolean cond_13 = null;
      cond_13 = new Boolean(data.containsKey(fname));
      if (cond_13.booleanValue()) 
        setRhsType((IOmlType) data.get(fname));
    }
  }
// ***** VDMTOOLS END Name=init


// ***** VDMTOOLS START Name=getLhsType KEEP=NO
  public IOmlType getLhsType () throws CGException {
    return (IOmlType) ivLhsType;
  }
// ***** VDMTOOLS END Name=getLhsType


// ***** VDMTOOLS START Name=setLhsType KEEP=NO
  public void setLhsType (final IOmlType parg) throws CGException {
    ivLhsType = (IOmlType) UTIL.clone(parg);
  }
// ***** VDMTOOLS END Name=setLhsType


// ***** VDMTOOLS START Name=getRhsType KEEP=NO
  public IOmlType getRhsType () throws CGException {
    return (IOmlType) ivRhsType;
  }
// ***** VDMTOOLS END Name=getRhsType


// ***** VDMTOOLS START Name=setRhsType KEEP=NO
  public void setRhsType (final IOmlType parg) throws CGException {
    ivRhsType = (IOmlType) UTIL.clone(parg);
  }
// ***** VDMTOOLS END Name=setRhsType

  public String toString() {
	  return this.ivLhsType.toString() + "*" + this.ivRhsType.toString();
  }
}
;
