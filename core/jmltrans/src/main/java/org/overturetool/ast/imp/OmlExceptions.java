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



public class OmlExceptions extends OmlNode implements IOmlExceptions {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=ivErrorList KEEP=NO
  private Vector ivErrorList = null;
// ***** VDMTOOLS END Name=ivErrorList


// ***** VDMTOOLS START Name=OmlExceptions KEEP=NO
  public OmlExceptions () throws CGException {
    try {
      ivErrorList = new Vector();
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=OmlExceptions


// ***** VDMTOOLS START Name=identity KEEP=NO
  public String identity () throws CGException {
    return new String("Exceptions");
  }
// ***** VDMTOOLS END Name=identity


// ***** VDMTOOLS START Name=accept KEEP=NO
  public void accept (final IOmlVisitor pVisitor) throws CGException {
    pVisitor.visitExceptions((IOmlExceptions) this);
  }
// ***** VDMTOOLS END Name=accept


// ***** VDMTOOLS START Name=OmlExceptions KEEP=NO
  public OmlExceptions (final Vector p1) throws CGException {

    try {
      ivErrorList = new Vector();
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    setErrorList(p1);
  }
// ***** VDMTOOLS END Name=OmlExceptions


// ***** VDMTOOLS START Name=OmlExceptions KEEP=NO
  public OmlExceptions (final Vector p1, final Long line, final Long column) throws CGException {

    try {
      ivErrorList = new Vector();
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    {

      setErrorList(p1);
      setPosition(line, column);
    }
  }
// ***** VDMTOOLS END Name=OmlExceptions


// ***** VDMTOOLS START Name=init KEEP=NO
  public void init (final HashMap data) throws CGException {

    String fname = new String("error_list");
    Boolean cond_4 = null;
    cond_4 = new Boolean(data.containsKey(fname));
    if (cond_4.booleanValue()) 
      setErrorList((Vector) data.get(fname));
  }
// ***** VDMTOOLS END Name=init


// ***** VDMTOOLS START Name=getErrorList KEEP=NO
  public Vector getErrorList () throws CGException {
    return ivErrorList;
  }
// ***** VDMTOOLS END Name=getErrorList


// ***** VDMTOOLS START Name=setErrorList KEEP=NO
  public void setErrorList (final Vector parg) throws CGException {
    ivErrorList = (Vector) UTIL.ConvertToList(UTIL.clone(parg));
  }
// ***** VDMTOOLS END Name=setErrorList


// ***** VDMTOOLS START Name=addErrorList KEEP=NO
  public void addErrorList (final IOmlNode parg) throws CGException {
    ivErrorList.add(parg);
  }
// ***** VDMTOOLS END Name=addErrorList

  public String toString() {
	  String error = new String();
	  int i, size = this.ivErrorList.size();
	  
	  if(size > 0) {
	  for(i=0; i< size-1; i++) {
		  error += this.ivErrorList.get(i).toString() + "\n";
	  }
	  error += this.ivErrorList.get(size-1).toString();
	  return "errs " + error;
	  }
	  else
		  return "";
  }
}
;
