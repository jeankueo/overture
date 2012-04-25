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



public class OmlSymbolicLiteralExpression extends OmlExpression implements IOmlSymbolicLiteralExpression {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=ivLiteral KEEP=NO
  private IOmlLiteral ivLiteral = null;
// ***** VDMTOOLS END Name=ivLiteral


// ***** VDMTOOLS START Name=OmlSymbolicLiteralExpression KEEP=NO
  public OmlSymbolicLiteralExpression () throws CGException {
    try {
      ivLiteral = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=OmlSymbolicLiteralExpression


// ***** VDMTOOLS START Name=identity KEEP=NO
  public String identity () throws CGException {
    return new String("SymbolicLiteralExpression");
  }
// ***** VDMTOOLS END Name=identity


// ***** VDMTOOLS START Name=accept KEEP=NO
  public void accept (final IOmlVisitor pVisitor) throws CGException {
    pVisitor.visitSymbolicLiteralExpression((IOmlSymbolicLiteralExpression) this);
  }
// ***** VDMTOOLS END Name=accept


// ***** VDMTOOLS START Name=OmlSymbolicLiteralExpression KEEP=NO
  public OmlSymbolicLiteralExpression (final IOmlLiteral p1) throws CGException {

    try {
      ivLiteral = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    setLiteral((IOmlLiteral) p1);
  }
// ***** VDMTOOLS END Name=OmlSymbolicLiteralExpression


// ***** VDMTOOLS START Name=OmlSymbolicLiteralExpression KEEP=NO
  public OmlSymbolicLiteralExpression (final IOmlLiteral p1, final Long line, final Long column) throws CGException {

    try {
      ivLiteral = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    {

      setLiteral((IOmlLiteral) p1);
      setPosition(line, column);
    }
  }
// ***** VDMTOOLS END Name=OmlSymbolicLiteralExpression


// ***** VDMTOOLS START Name=init KEEP=NO
  public void init (final HashMap data) throws CGException {

    String fname = new String("literal");
    Boolean cond_4 = null;
    cond_4 = new Boolean(data.containsKey(fname));
    if (cond_4.booleanValue()) 
      setLiteral((IOmlLiteral) data.get(fname));
  }
// ***** VDMTOOLS END Name=init


// ***** VDMTOOLS START Name=getLiteral KEEP=NO
  public IOmlLiteral getLiteral () throws CGException {
    return (IOmlLiteral) ivLiteral;
  }
// ***** VDMTOOLS END Name=getLiteral


// ***** VDMTOOLS START Name=setLiteral KEEP=NO
  public void setLiteral (final IOmlLiteral parg) throws CGException {
    ivLiteral = (IOmlLiteral) UTIL.clone(parg);
  }
// ***** VDMTOOLS END Name=setLiteral

}
;
