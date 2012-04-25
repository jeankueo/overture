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



public class OmlValueDefinitions extends OmlDefinitionBlock implements IOmlValueDefinitions {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=ivValueList KEEP=NO
  private Vector ivValueList = null;
// ***** VDMTOOLS END Name=ivValueList


// ***** VDMTOOLS START Name=OmlValueDefinitions KEEP=NO
  public OmlValueDefinitions () throws CGException {
    try {
      ivValueList = new Vector();
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=OmlValueDefinitions


// ***** VDMTOOLS START Name=identity KEEP=NO
  public String identity () throws CGException {
    return new String("ValueDefinitions");
  }
// ***** VDMTOOLS END Name=identity


// ***** VDMTOOLS START Name=accept KEEP=NO
  public void accept (final IOmlVisitor pVisitor) throws CGException {
    pVisitor.visitValueDefinitions((IOmlValueDefinitions) this);
  }
// ***** VDMTOOLS END Name=accept


// ***** VDMTOOLS START Name=OmlValueDefinitions KEEP=NO
  public OmlValueDefinitions (final Vector p1) throws CGException {

    try {
      ivValueList = new Vector();
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    setValueList(p1);
  }
// ***** VDMTOOLS END Name=OmlValueDefinitions


// ***** VDMTOOLS START Name=OmlValueDefinitions KEEP=NO
  public OmlValueDefinitions (final Vector p1, final Long line, final Long column) throws CGException {

    try {
      ivValueList = new Vector();
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    {

      setValueList(p1);
      setPosition(line, column);
    }
  }
// ***** VDMTOOLS END Name=OmlValueDefinitions


// ***** VDMTOOLS START Name=init KEEP=NO
  public void init (final HashMap data) throws CGException {

    String fname = new String("value_list");
    Boolean cond_4 = null;
    cond_4 = new Boolean(data.containsKey(fname));
    if (cond_4.booleanValue()) 
      setValueList((Vector) data.get(fname));
  }
// ***** VDMTOOLS END Name=init


// ***** VDMTOOLS START Name=getValueList KEEP=NO
  public Vector getValueList () throws CGException {
    return ivValueList;
  }
// ***** VDMTOOLS END Name=getValueList


// ***** VDMTOOLS START Name=setValueList KEEP=NO
  public void setValueList (final Vector parg) throws CGException {
    ivValueList = (Vector) UTIL.ConvertToList(UTIL.clone(parg));
  }
// ***** VDMTOOLS END Name=setValueList


// ***** VDMTOOLS START Name=addValueList KEEP=NO
  public void addValueList (final IOmlNode parg) throws CGException {
    ivValueList.add(parg);
  }
// ***** VDMTOOLS END Name=addValueList

  public String toString() {
	  String lst = new String();
	  int i, size = this.ivValueList.size();
	  
	  if (size>0) {
		  for(i=0; i<size; i++) {
			  lst += this.ivValueList.get(i).toString() + ";\n";
		  }
	  }
	  return "values\n\n" + lst;
  }
}
;
