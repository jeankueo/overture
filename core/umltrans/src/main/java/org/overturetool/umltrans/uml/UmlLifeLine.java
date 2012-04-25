


//
// THIS FILE IS AUTOMATICALLY GENERATED!!
//
// Generated at 2009-11-27 by the VDM++ to JAVA Code Generator
// (v8.2 - Fri 29-May-2009 11:13:11)
//
// Supported compilers: jdk 1.4/1.5/1.6
//

// ***** VDMTOOLS START Name=HeaderComment KEEP=NO
// ***** VDMTOOLS END Name=HeaderComment

// ***** VDMTOOLS START Name=package KEEP=NO
package org.overturetool.umltrans.uml;

// ***** VDMTOOLS END Name=package

// ***** VDMTOOLS START Name=imports KEEP=NO

import jp.co.csk.vdm.toolbox.VDM.*;
import java.util.*;
import org.overturetool.ast.itf.*;
import org.overturetool.ast.imp.*;
import org.overturetool.api.io.*;
import org.overturetool.api.io.*;
import org.overturetool.api.xml.*;
import org.overturetool.umltrans.api.*;
import org.overturetool.umltrans.*;
import org.overturetool.umltrans.uml.*;
import org.overturetool.umltrans.uml2vdm.*;
import org.overturetool.umltrans.vdm2uml.*;
// ***** VDMTOOLS END Name=imports



@SuppressWarnings({"all","unchecked","unused"})
public class UmlLifeLine extends IUmlLifeLine {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=ivName KEEP=NO
  private String ivName = null;
// ***** VDMTOOLS END Name=ivName

// ***** VDMTOOLS START Name=ivRepresents KEEP=NO
  private IUmlType ivRepresents = null;
// ***** VDMTOOLS END Name=ivRepresents


// ***** VDMTOOLS START Name=vdm_init_UmlLifeLine KEEP=NO
  private void vdm_init_UmlLifeLine () throws CGException {
    try {

      ivName = UTIL.ConvertToString(new String());
      ivRepresents = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=vdm_init_UmlLifeLine


// ***** VDMTOOLS START Name=UmlLifeLine KEEP=NO
  public UmlLifeLine () throws CGException {
    vdm_init_UmlLifeLine();
  }
// ***** VDMTOOLS END Name=UmlLifeLine


// ***** VDMTOOLS START Name=identity KEEP=NO
  public String identity () throws CGException {
    return new String("LifeLine");
  }
// ***** VDMTOOLS END Name=identity


// ***** VDMTOOLS START Name=accept#1|IUmlVisitor KEEP=NO
  public void accept (final IUmlVisitor pVisitor) throws CGException {
    pVisitor.visitLifeLine((IUmlLifeLine) this);
  }
// ***** VDMTOOLS END Name=accept#1|IUmlVisitor


// ***** VDMTOOLS START Name=UmlLifeLine#2|String|IUmlType KEEP=NO
  public UmlLifeLine (final String p1, final IUmlType p2) throws CGException {

    vdm_init_UmlLifeLine();
    {

      setName(p1);
      setRepresents((IUmlType) p2);
    }
  }
// ***** VDMTOOLS END Name=UmlLifeLine#2|String|IUmlType


// ***** VDMTOOLS START Name=UmlLifeLine#4|String|IUmlType|Long|Long KEEP=NO
  public UmlLifeLine (final String p1, final IUmlType p2, final Long line, final Long column) throws CGException {

    vdm_init_UmlLifeLine();
    {

      setName(p1);
      setRepresents((IUmlType) p2);
      setPosition(line, column);
    }
  }
// ***** VDMTOOLS END Name=UmlLifeLine#4|String|IUmlType|Long|Long


// ***** VDMTOOLS START Name=init#1|HashMap KEEP=NO
  public void init (final HashMap data) throws CGException {

    {

      String fname = new String("name");
      Boolean cond_4 = null;
      cond_4 = new Boolean(data.containsKey(fname));
      if (cond_4.booleanValue()) 
        setName(UTIL.ConvertToString(data.get(fname)));
    }
    {

      String fname = new String("represents");
      Boolean cond_13 = null;
      cond_13 = new Boolean(data.containsKey(fname));
      if (cond_13.booleanValue()) 
        setRepresents((IUmlType) data.get(fname));
    }
  }
// ***** VDMTOOLS END Name=init#1|HashMap


// ***** VDMTOOLS START Name=getName KEEP=NO
  public String getName () throws CGException {
    return ivName;
  }
// ***** VDMTOOLS END Name=getName


// ***** VDMTOOLS START Name=setName#1|String KEEP=NO
  public void setName (final String parg) throws CGException {
    ivName = UTIL.ConvertToString(UTIL.clone(parg));
  }
// ***** VDMTOOLS END Name=setName#1|String


// ***** VDMTOOLS START Name=getRepresents KEEP=NO
  public IUmlType getRepresents () throws CGException {
    return (IUmlType) ivRepresents;
  }
// ***** VDMTOOLS END Name=getRepresents


// ***** VDMTOOLS START Name=hasRepresents KEEP=NO
  public Boolean hasRepresents () throws CGException {
    return new Boolean(!UTIL.equals(ivRepresents, null));
  }
// ***** VDMTOOLS END Name=hasRepresents


// ***** VDMTOOLS START Name=setRepresents#1|IUmlType KEEP=NO
  public void setRepresents (final IUmlType parg) throws CGException {
    ivRepresents = (IUmlType) UTIL.clone(parg);
  }
// ***** VDMTOOLS END Name=setRepresents#1|IUmlType

}
;