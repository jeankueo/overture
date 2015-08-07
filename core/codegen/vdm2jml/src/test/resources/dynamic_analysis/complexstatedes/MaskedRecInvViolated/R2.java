package project.Entrytypes;

import org.overture.codegen.runtime.*;

import java.util.*;


//@ nullable_by_default
@SuppressWarnings("all")
final public class R2 implements Record {
    public project.Entrytypes.R3 t3;

    //@ public instance invariant project.Entry.invChecksOn ==> inv_R2(t3);
    public R2(final project.Entrytypes.R3 _t3) {
        //@ assert _t3.valid();
        //@ assert inv_Entry_T3(_t3);
        t3 = (_t3 != null) ? Utils.copy(_t3) : null;

        //@ assert t3.valid();
        //@ assert inv_Entry_T3(t3);
    }

    /*@ pure @*/
    public boolean equals(final Object obj) {
        if (!(obj instanceof project.Entrytypes.R2)) {
            return false;
        }

        project.Entrytypes.R2 other = ((project.Entrytypes.R2) obj);

        return Utils.equals(t3, other.t3);
    }

    /*@ pure @*/
    public int hashCode() {
        return Utils.hashCode(t3);
    }

    /*@ pure @*/
    public project.Entrytypes.R2 copy() {
        return new project.Entrytypes.R2(t3);
    }

    /*@ pure @*/
    public String toString() {
        return "mk_Entry`R2" + Utils.formatFields(t3);
    }

    /*@ pure @*/
    public project.Entrytypes.R3 get_t3() {
        project.Entrytypes.R3 ret_1 = t3;

        //@ assert project.Entry.invChecksOn ==> ret_1.valid();
        //@ assert project.Entry.invChecksOn ==> (inv_Entry_T3(ret_1));
        return ret_1;
    }

    public void set_t3(final project.Entrytypes.R3 _t3) {
        //@ assert project.Entry.invChecksOn ==> _t3.valid();
        //@ assert project.Entry.invChecksOn ==> (inv_Entry_T3(_t3));
        t3 = _t3;

        //@ assert project.Entry.invChecksOn ==> t3.valid();
        //@ assert project.Entry.invChecksOn ==> (inv_Entry_T3(t3));
    }

    /*@ pure @*/
    public Boolean valid() {
        return true;
    }

    /*@ pure @*/
    /*@ helper @*/
    public static Boolean inv_R2(final project.Entrytypes.R3 _t3) {
        return !(Utils.equals(_t3.r4.x, 2L));
    }

    /*@ pure @*/
    /*@ helper @*/
    public static Boolean inv_Entry_T3(final Object check_t3) {
        if ((Utils.equals(check_t3, null)) ||
                !(Utils.is_(check_t3, project.Entrytypes.R3.class))) {
            return false;
        }

        project.Entrytypes.R3 t3 = ((project.Entrytypes.R3) check_t3);

        return !(Utils.equals(t3.get_r4().get_x(), 10L));
    }
}
