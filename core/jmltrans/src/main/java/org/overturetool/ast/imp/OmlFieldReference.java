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



public class OmlFieldReference extends OmlStateDesignator implements IOmlFieldReference {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=ivStateDesignator KEEP=NO
  private IOmlStateDesignator ivStateDesignator = null;
// ***** VDMTOOLS END Name=ivStateDesignator

// ***** VDMTOOLS START Name=ivIdentifier KEEP=NO
  private String ivIdentifier = null;
// ***** VDMTOOLS END Name=ivIdentifier


// ***** VDMTOOLS START Name=OmlFieldReference KEEP=NO
  public OmlFieldReference () throws CGException {
    try {

      ivStateDesignator = null;
      ivIdentifier = UTIL.ConvertToString(new String());
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=OmlFieldReference


// ***** VDMTOOLS START Name=identity KEEP=NO
  public String identity () throws CGException {
    return new String("FieldReference");
  }
// ***** VDMTOOLS END Name=identity


// ***** VDMTOOLS START Name=accept KEEP=NO
  public void accept (final IOmlVisitor pVisitor) throws CGException {
    pVisitor.visitFieldReference((IOmlFieldReference) this);
  }
// ***** VDMTOOLS END Name=accept


// ***** VDMTOOLS START Name=OmlFieldReference KEEP=NO
  public OmlFieldReference (final IOmlStateDesignator p1, final String p2) throws CGException {

    try {

      ivStateDesignator = null;
      ivIdentifier = UTIL.ConvertToString(new String());
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    {

      setStateDesignator((IOmlStateDesignator) p1);
      setIdentifier(p2);
    }
  }
// ***** VDMTOOLS END Name=OmlFieldReference


// ***** VDMTOOLS START Name=OmlFieldReference KEEP=NO
  public OmlFieldReference (final IOmlStateDesignator p1, final String p2, final Long line, final Long column) throws CGException {

    try {

      ivStateDesignator = null;
      ivIdentifier = UTIL.ConvertToString(new String());
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    {

      setStateDesignator((IOmlStateDesignator) p1);
      setIdentifier(p2);
      setPosition(line, column);
    }
  }
// ***** VDMTOOLS END Name=OmlFieldReference


// ***** VDMTOOLS START Name=init KEEP=NO
  public void init (final HashMap data) throws CGException {

    {

      String fname = new String("state_designator");
      Boolean cond_4 = null;
      cond_4 = new Boolean(data.containsKey(fname));
      if (cond_4.booleanValue()) 
        setStateDesignator((IOmlStateDesignator) data.get(fname));
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


// ***** VDMTOOLS START Name=getStateDesignator KEEP=NO
  public IOmlStateDesignator getStateDesignator () throws CGException {
    return (IOmlStateDesignator) ivStateDesignator;
  }
// ***** VDMTOOLS END Name=getStateDesignator


// ***** VDMTOOLS START Name=setStateDesignator KEEP=NO
  public void setStateDesignator (final IOmlStateDesignator parg) throws CGException {
    ivStateDesignator = (IOmlStateDesignator) UTIL.clone(parg);
  }
// ***** VDMTOOLS END Name=setStateDesignator


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
	  return this.ivStateDesignator.toString() + "." + this.ivIdentifier;
  }
}
;
