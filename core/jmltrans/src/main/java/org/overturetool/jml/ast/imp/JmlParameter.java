//
// THIS FILE IS AUTOMATICALLY GENERATED!!
//
// Generated at Mon 07-Jul-2008 by the VDM++ to JAVA Code Generator
// (v8.1.1b - Fri 06-Jun-2008 09:02:11)
//
// Supported compilers:
// jdk1.4
//

// ***** VDMTOOLS START Name=HeaderComment KEEP=NO
// ***** VDMTOOLS END Name=HeaderComment

// ***** VDMTOOLS START Name=package KEEP=NO
package org.overturetool.jml.ast.imp;

// ***** VDMTOOLS END Name=package

// ***** VDMTOOLS START Name=imports KEEP=YES

import jp.co.csk.vdm.toolbox.VDM.*;
import java.util.*;
import org.overturetool.jml.ast.itf.*;
@SuppressWarnings(all) 
// ***** VDMTOOLS END Name=imports



public class JmlParameter extends JmlNode implements IJmlParameter {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=ivType KEEP=NO
  private IJmlType ivType = null;
// ***** VDMTOOLS END Name=ivType

// ***** VDMTOOLS START Name=ivIdentifier KEEP=NO
  private String ivIdentifier = null;
// ***** VDMTOOLS END Name=ivIdentifier


// ***** VDMTOOLS START Name=JmlParameter KEEP=NO
  public JmlParameter () throws CGException {
    try {

      ivType = null;
      ivIdentifier = UTIL.ConvertToString(new String());
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=JmlParameter


// ***** VDMTOOLS START Name=identity KEEP=NO
  public String identity () throws CGException {
    return new String("Parameter");
  }
// ***** VDMTOOLS END Name=identity


// ***** VDMTOOLS START Name=accept KEEP=NO
  public void accept (final IJmlVisitor pVisitor) throws CGException {
    pVisitor.visitParameter((IJmlParameter) this);
  }
// ***** VDMTOOLS END Name=accept


// ***** VDMTOOLS START Name=JmlParameter KEEP=NO
  public JmlParameter (final IJmlType p1, final String p2) throws CGException {

    try {

      ivType = null;
      ivIdentifier = UTIL.ConvertToString(new String());
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    {

      setType((IJmlType) p1);
      setIdentifier(p2);
    }
  }
// ***** VDMTOOLS END Name=JmlParameter


// ***** VDMTOOLS START Name=JmlParameter KEEP=NO
  public JmlParameter (final IJmlType p1, final String p2, final Long line, final Long column) throws CGException {

    try {

      ivType = null;
      ivIdentifier = UTIL.ConvertToString(new String());
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    {

      setType((IJmlType) p1);
      setIdentifier(p2);
      setPosition(line, column);
    }
  }
// ***** VDMTOOLS END Name=JmlParameter


// ***** VDMTOOLS START Name=init KEEP=NO
  public void init (final HashMap data) throws CGException {

    {

      String fname = new String("type");
      Boolean cond_4 = null;
      cond_4 = new Boolean(data.containsKey(fname));
      if (cond_4.booleanValue()) 
        setType((IJmlType) data.get(fname));
    }
    {

      String fname = new String("identifier");
      Boolean cond_13 = null;
      cond_13 = new Boolean(data.containsKey(fname));
      if (cond_13.booleanValue()) 
        setIdentifier(UTIL.ConvertToString(data.get(fname)));
    }
  }
// ***** VDMTOOLS END Name=init


// ***** VDMTOOLS START Name=getType KEEP=NO
  public IJmlType getType () throws CGException {
    return (IJmlType) ivType;
  }
// ***** VDMTOOLS END Name=getType


// ***** VDMTOOLS START Name=setType KEEP=NO
  public void setType (final IJmlType parg) throws CGException {
    ivType = (IJmlType) UTIL.clone(parg);
  }
// ***** VDMTOOLS END Name=setType


// ***** VDMTOOLS START Name=getIdentifier KEEP=NO
  public String getIdentifier () throws CGException {
    return ivIdentifier;
  }
// ***** VDMTOOLS END Name=getIdentifier


// ***** VDMTOOLS START Name=setIdentifier KEEP=NO
  public void setIdentifier (final String parg) throws CGException {
    ivIdentifier = UTIL.ConvertToString(UTIL.clone(parg));
  }
// ***** VDMTOOLS END Name=setIdentifier
  
  public String toString() {
	  
	  return this.ivType.toString() + " " + this.ivIdentifier;
  }

}
;
