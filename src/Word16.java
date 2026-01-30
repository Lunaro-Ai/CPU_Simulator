import java.util.Arrays;

public class Word16 {

    private Bit[] bits = new Bit[16];


    public Word16() {
        for (int i = 0; i < bits.length; i++) {
            bits[i] = new Bit(false);
        }
    }

    public Word16(Bit[] in) {
        for (int i = 0; i < in.length; i++) {
            bits[i] = new Bit(false);
        }
    }

    public void copy(Word16 result) {// sets the values in "result" to be the same as the values in this instance; use "bit.assign"
        for (int i = 0; i < 16; i++) result.bits[i].assign(bits[i].getValue());
    }


    public void setBitN(int n, Bit source) {// sets the nth bit of this word to "source"
        bits[n].assign(source.getValue());
    }

    public void getBitN(int n, Bit result) { // sets result to be the same value as the nth bit of this word
        result.assign(bits[n].getValue());
    }

    public boolean equals(Word16 other) {// is other equal to this
        return Word16.equals(this, other);
    }

    public static boolean equals(Word16 a, Word16 b) {

        for (int i = 0; i < 16; i++) {
            if (a.bits[i].getValue() != b.bits[i].getValue()) {
                return false;
            }
        }
        return true;
    }

    public void and(Word16 other, Word16 result) {
        Word16.and(this, other, result);

    }

    public static void and(Word16 a, Word16 b, Word16 result) {

        for (int i = 0; i < 16; i++) {
            if (!a.bits[i].getValue()) {
                result.bits[i] = new Bit(false);
            }
            else if (!b.bits[i].getValue()) {
                result.bits[i] = new Bit(false);
            }
            else result.bits[i] = new Bit(true);

        }
    }


    public void or(Word16 other, Word16 result) {
        Word16.or(this,other,result);
    }

    public static void or(Word16 a, Word16 b, Word16 result) {
        for (int i = 0; i < 16; i++) {
            if (!a.bits[i].getValue()) {
                if (!b.bits[i].getValue()) result.bits[i] = new Bit(false);
            } else result.bits[i] = new Bit(true);

        }
    }

    public void xor(Word16 other, Word16 result) {
        Word16.xor(this,other,result);
    }

    public static void xor(Word16 a, Word16 b, Word16 result) {
        for (int i = 0; i < 16; i++) {
            if (a.bits[i].getValue() == b.bits[i].getValue()) result.bits[i] = new Bit(false);
            else result.bits[i]= new Bit(true);
        }
    }

    public void not( Word16 result) {
        Word16.not(this,result);
    }

    public static void not(Word16 a, Word16 result) {
        for (int i = 0; i < 16; i++) {
            if (a.bits[i].getValue()) result.bits[i] = new Bit(false);
            else result.bits[i] = new Bit(true);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        // -- match this format
        for (Bit bit : bits) {
            sb.append(bit.toString());
            sb.append(",");
        }

        return sb.toString();
    }
}