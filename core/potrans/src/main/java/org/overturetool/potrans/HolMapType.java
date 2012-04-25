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



public class HolMapType extends HolType {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=domType KEEP=NO
  private HolType domType = null;
// ***** VDMTOOLS END Name=domType

// ***** VDMTOOLS START Name=rngType KEEP=NO
  private HolType rngType = null;
// ***** VDMTOOLS END Name=rngType


// ***** VDMTOOLS START Name=vdm_init_HolMapType KEEP=NO
  private void vdm_init_HolMapType () throws CGException {}
// ***** VDMTOOLS END Name=vdm_init_HolMapType


// ***** VDMTOOLS START Name=HolMapType KEEP=NO
  public HolMapType () throws CGException {
    vdm_init_HolMapType();
  }
// ***** VDMTOOLS END Name=HolMapType


// ***** VDMTOOLS START Name=HolMapType#2|HolType|HolType KEEP=NO
  public HolMapType (final HolType newDomType, final HolType newRngType) throws CGException {

    vdm_init_HolMapType();
    {

      domType = (HolType) UTIL.clone(newDomType);
      rngType = (HolType) UTIL.clone(newRngType);
    }
  }
// ***** VDMTOOLS END Name=HolMapType#2|HolType|HolType


// ***** VDMTOOLS START Name=setTypeInformation#1|HolTypeDescription KEEP=NO
  public void setTypeInformation (final HolTypeDescription typeInfo) throws CGException {

    domType.setTypeInformation((HolTypeDescription) typeInfo);
    rngType.setTypeInformation((HolTypeDescription) typeInfo);
  }
// ***** VDMTOOLS END Name=setTypeInformation#1|HolTypeDescription


// ***** VDMTOOLS START Name=requires KEEP=NO
  public HashSet requires () throws CGException {

    HashSet rexpr_1 = new HashSet();
    HashSet var1_2 = new HashSet();
    var1_2 = domType.requires();
    HashSet var2_3 = new HashSet();
    var2_3 = rngType.requires();
    rexpr_1 = (HashSet) var1_2.clone();
    rexpr_1.addAll(var2_3);
    return rexpr_1;
  }
// ***** VDMTOOLS END Name=requires


// ***** VDMTOOLS START Name=print#1|Object KEEP=NO
  public String print (final Object specType) throws CGException {

    String rexpr_2 = null;
    Vector unArg_3 = null;
    unArg_3 = new Vector();
    unArg_3.add(new String("(("));
    String e_seq_5 = null;
    e_seq_5 = domType.print(specType);
    unArg_3.add(e_seq_5);
    unArg_3.add(new String(", "));
    String e_seq_8 = null;
    e_seq_8 = rngType.print(specType);
    unArg_3.add(e_seq_8);
    unArg_3.add(new String(") fmap)"));
    String rdcseq_11 = new String();
    for (Iterator enm_14 = unArg_3.iterator(); enm_14.hasNext(); ) {

      String e_12 = UTIL.ConvertToString(enm_14.next());
      rdcseq_11 = rdcseq_11.concat(e_12);
    }
    rexpr_2 = rdcseq_11;
    return rexpr_2;
  }
// ***** VDMTOOLS END Name=print#1|Object

}
;
