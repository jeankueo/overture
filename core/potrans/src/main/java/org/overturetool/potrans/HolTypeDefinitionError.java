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



public class HolTypeDefinitionError extends HolTypeDefinition {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=message KEEP=NO
  private String message = null;
// ***** VDMTOOLS END Name=message


// ***** VDMTOOLS START Name=vdm_init_HolTypeDefinitionError KEEP=NO
  private void vdm_init_HolTypeDefinitionError () throws CGException {}
// ***** VDMTOOLS END Name=vdm_init_HolTypeDefinitionError


// ***** VDMTOOLS START Name=HolTypeDefinitionError KEEP=NO
  public HolTypeDefinitionError () throws CGException {
    vdm_init_HolTypeDefinitionError();
  }
// ***** VDMTOOLS END Name=HolTypeDefinitionError


// ***** VDMTOOLS START Name=HolTypeDefinitionError#1|String KEEP=NO
  public HolTypeDefinitionError (final String newMessage) throws CGException {

    vdm_init_HolTypeDefinitionError();
    {

      HolTranslationError.construct(newMessage);
      message = UTIL.ConvertToString(UTIL.clone(newMessage));
    }
  }
// ***** VDMTOOLS END Name=HolTypeDefinitionError#1|String


// ***** VDMTOOLS START Name=requires KEEP=NO
  public HashSet requires () throws CGException {
    return new HashSet();
  }
// ***** VDMTOOLS END Name=requires


// ***** VDMTOOLS START Name=provides KEEP=NO
  public HashSet provides () throws CGException {
    return new HashSet();
  }
// ***** VDMTOOLS END Name=provides


// ***** VDMTOOLS START Name=print KEEP=NO
  public String print () throws CGException {

    String rexpr_1 = null;
    rexpr_1 = UTIL.ConvertToString(HolTranslationError.print(message));
    return rexpr_1;
  }
// ***** VDMTOOLS END Name=print

}
;
