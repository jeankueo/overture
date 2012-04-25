


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
package org.overturetool.umltrans;

// ***** VDMTOOLS END Name=package

// ***** VDMTOOLS START Name=imports KEEP=YES

import jp.co.csk.vdm.toolbox.VDM.*;

import java.io.PrintWriter;
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
public class StatusLog {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=log KEEP=YES
  private Vector log = null;
  public static PrintWriter out=new PrintWriter(System.out);
// ***** VDMTOOLS END Name=log


// ***** VDMTOOLS START Name=vdm_init_StatusLog KEEP=NO
  private void vdm_init_StatusLog () throws CGException {
    try {
      log = new Vector();
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=vdm_init_StatusLog


// ***** VDMTOOLS START Name=StatusLog KEEP=NO
  public StatusLog () throws CGException {
    vdm_init_StatusLog();
  }
// ***** VDMTOOLS END Name=StatusLog


// ***** VDMTOOLS START Name=info#1|String KEEP=YES
  public void info (final String message) throws CGException {
	  System.out.println("[INFO] "+message);
  }
// ***** VDMTOOLS END Name=info#1|String


// ***** VDMTOOLS START Name=warn#1|String KEEP=YES
  public void warn (final String message) throws CGException {
	  System.out.println("[WARNING] "+message);
  }
// ***** VDMTOOLS END Name=warn#1|String


// ***** VDMTOOLS START Name=addNewClassInfo#1|String KEEP=NO
  public void addNewClassInfo (final String name) throws CGException {
    log.add(new ClassStatus(name, new String(""), getTime(), new Long(0)));
  }
// ***** VDMTOOLS END Name=addNewClassInfo#1|String


// ***** VDMTOOLS START Name=addNewClassInfo#2|String|String KEEP=NO
  public void addNewClassInfo (final String name, final String i) throws CGException {
    log.add(new ClassStatus(name, i, getTime(), new Long(0)));
  }
// ***** VDMTOOLS END Name=addNewClassInfo#2|String|String


// ***** VDMTOOLS START Name=endClass#2|String|String KEEP=NO
  public void endClass (final String name, final String id) throws CGException {

    HashSet a = new HashSet();
    HashSet res_s_5 = new HashSet();
    {

      HashSet e1_set_15 = new HashSet(log);
      ClassStatus c = null;
      {
        for (Iterator enm_17 = e1_set_15.iterator(); enm_17.hasNext(); ) {

          ClassStatus elem_16 = (ClassStatus) enm_17.next();
          c = (ClassStatus) elem_16;
          Boolean pred_9 = null;
          String var1_10 = null;
          var1_10 = c.name;
          pred_9 = new Boolean(UTIL.equals(var1_10, name));
          if (pred_9.booleanValue()) {
            res_s_5.add(setdd((ClassStatus) c, id));
          }
        }
      }
    }
    a = res_s_5;
  }
// ***** VDMTOOLS END Name=endClass#2|String|String


// ***** VDMTOOLS START Name=endClass#1|String KEEP=NO
  public void endClass (final String name) throws CGException {

    HashSet a = new HashSet();
    HashSet res_s_4 = new HashSet();
    {

      HashSet e1_set_16 = new HashSet(log);
      ClassStatus c = null;
      {
        for (Iterator enm_18 = e1_set_16.iterator(); enm_18.hasNext(); ) {

          ClassStatus elem_17 = (ClassStatus) enm_18.next();
          c = (ClassStatus) elem_17;
          Boolean pred_10 = null;
          String var1_11 = null;
          var1_11 = c.name;
          pred_10 = new Boolean(UTIL.equals(var1_11, name));
          if (pred_10.booleanValue()) {

            Long res_s_5 = null;
            res_s_5 = UTIL.NumberToLong(setd(c));
            res_s_4.add(res_s_5);
          }
        }
      }
    }
    a = res_s_4;
  }
// ***** VDMTOOLS END Name=endClass#1|String


// ***** VDMTOOLS START Name=setdd#2|ClassStatus|String KEEP=NO
  private Long setdd (final ClassStatus node, final String id) throws CGException {

    node.setId(id);
    node.setEndTime(getTime());
    return new Long(0);
  }
// ***** VDMTOOLS END Name=setdd#2|ClassStatus|String


// ***** VDMTOOLS START Name=setd#2|ClassStatus|String KEEP=NO
  private Long setd (final ClassStatus node, final String id) throws CGException {

    node.setId(id);
    node.setEndTime(getTime());
    return new Long(0);
  }
// ***** VDMTOOLS END Name=setd#2|ClassStatus|String


// ***** VDMTOOLS START Name=setd#1|ClassStatus KEEP=NO
  private Long setd (final ClassStatus node) throws CGException {

    node.setEndTime(getTime());
    return new Long(0);
  }
// ***** VDMTOOLS END Name=setd#1|ClassStatus


// ***** VDMTOOLS START Name=getTime KEEP=NO
  private Long getTime () throws CGException {
    return new Long(0);
  }
// ***** VDMTOOLS END Name=getTime


// ***** VDMTOOLS START Name=mappingNotSupported#1|IOmlValueDefinition KEEP=NO
  public void mappingNotSupported (final IOmlValueDefinition item) throws CGException {}
// ***** VDMTOOLS END Name=mappingNotSupported#1|IOmlValueDefinition


// ***** VDMTOOLS START Name=mappingNotSupported#2|Vector|IOmlType KEEP=NO
  public void mappingNotSupported (final Vector items, final IOmlType type) throws CGException {}
// ***** VDMTOOLS END Name=mappingNotSupported#2|Vector|IOmlType

}
;