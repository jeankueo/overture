//
// THIS FILE IS AUTOMATICALLY GENERATED!!
//
// Generated at 2008-11-08 by the VDM++ to JAVA Code Generator
// (v8.1.1b - Fri 24-Oct-2008 08:59:25)
//
// Supported compilers: jdk 1.4/1.5/1.6
//

// ***** VDMTOOLS START Name=HeaderComment KEEP=NO
// ***** VDMTOOLS END Name=HeaderComment

// ***** VDMTOOLS START Name=package KEEP=NO
package org.overturetool.potrans;

// ***** VDMTOOLS END Name=package

// ***** VDMTOOLS START Name=imports KEEP=YES

import jp.co.csk.vdm.toolbox.VDM.*;
import java.util.*;
// ***** VDMTOOLS END Name=imports



public class NonHolExpression extends MLExpression {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=val KEEP=NO
  private String val = null;
// ***** VDMTOOLS END Name=val


// ***** VDMTOOLS START Name=vdm_init_NonHolExpression KEEP=NO
  private void vdm_init_NonHolExpression () throws CGException {}
// ***** VDMTOOLS END Name=vdm_init_NonHolExpression


// ***** VDMTOOLS START Name=NonHolExpression KEEP=NO
  public NonHolExpression () throws CGException {
    vdm_init_NonHolExpression();
  }
// ***** VDMTOOLS END Name=NonHolExpression


// ***** VDMTOOLS START Name=NonHolExpression#1|String KEEP=NO
  public NonHolExpression (final String newVal) throws CGException {

    vdm_init_NonHolExpression();
    val = UTIL.ConvertToString(UTIL.clone(newVal));
  }
// ***** VDMTOOLS END Name=NonHolExpression#1|String


// ***** VDMTOOLS START Name=setTypeInformation#1|HolTypeDescription KEEP=NO
  public void setTypeInformation (final HolTypeDescription var_1_1) throws CGException {}
// ***** VDMTOOLS END Name=setTypeInformation#1|HolTypeDescription


// ***** VDMTOOLS START Name=requires KEEP=NO
  public HashSet requires () throws CGException {
    return new HashSet();
  }
// ***** VDMTOOLS END Name=requires


// ***** VDMTOOLS START Name=print KEEP=NO
  public String print () throws CGException {
    return val;
  }
// ***** VDMTOOLS END Name=print

}
;
