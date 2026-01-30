import java.nio.file.Files;
import java.security.cert.TrustAnchor;

public class Bit {

    private boolean truthVal;


    public Bit(boolean value) {
        this.truthVal = value;
    }

    public boolean getValue() {
        return truthVal;
    }

    public void assign(boolean value) {
        this.truthVal = value;
    }

    public void and(Bit b2, Bit result) {
        Bit.and(this,b2,result);
    }

    public static void and(Bit b1, Bit b2, Bit result) {
        if (!b1.getValue()) {
            result.assign(false);
        } else if (!b2.getValue()) {
            result.assign(false);
        } else {
            result.assign(true);
        }



    }

    public void or(Bit b2, Bit result) {
        Bit.or(this,b2,result);
    }

    public static void or(Bit b1, Bit b2, Bit result) {

        if (!b1.getValue()) {
            if (!b2.getValue()) {
                result.assign(false);
            } else result.assign(true);
        }
        else if (!b2.getValue()) {
            if (!b1.getValue()) {
                result.assign(false);
            } else result.assign(true);
        }
        else result.assign(true);



    }

    public void xor(Bit b2, Bit result) {
        Bit.xor(this,b2,result);
    }

    public static void xor(Bit b1, Bit b2, Bit result) {
        result.assign(b1.getValue() != b2.getValue());

    }

    public static void not(Bit b2, Bit result) {
        result.assign(!b2.getValue());
    }

    public void not(Bit result) {
        Bit.not(this,result);

    }

    public String toString() {
        return truthVal ? "1" : "0";
    }
}
