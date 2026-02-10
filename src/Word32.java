

public class Word32 {

    private Bit[] bits = new Bit[32];

    public Word32() {
        for (int i = 0; i < bits.length; i++) {
            this.bits[i] = new Bit(false);
        }
    }

    public Word32(Bit[] in) {
        for (int i = 0; i < bits.length; i++) {
           this.bits[i] = new Bit(in[i].getValue());
        }
    }

    public void getTopHalf(Word16 result) { // sets result = bits 0-15 of this word. use bit.assign
        //This uses assign already through setBitN
        for (int i = 0; i < 16; i++) result.setBitN(i,this.bits[i]);
    }

    public void getBottomHalf(Word16 result) { // sets result = bits 16-31 of this word. use bit.assign
        // fix this!!!!
        int index = 16;
        for (int i = 0; i < 16; i++) {
            result.setBitN(i,bits[index++]);
        }
    }

    public void copy(Word32 result) { // sets result's bit to be the same as this. use bit.assign
        // Might need to use bit.assign!!!
        for (int i = 0; i < bits.length; i++) result.bits[i].assign(this.bits[i].getValue());

    }

    public boolean equals(Word32 other) {
        return Word32.equals(this,other);
    }

    public static boolean equals(Word32 a, Word32 b) {
        for (int i = 0; i < 31; i++) {
            if (a.bits[i].getValue() != b.bits[i].getValue()) {
                return false;
            }
        }
        return true;
    }

    public void getBitN(int n, Bit result) { // use bit.assign
        result.assign(this.bits[n].getValue());
    }

    public void setBitN(int n, Bit source) { //  use bit.assign
        this.bits[n].assign(source.getValue());
    }

    public void and(Word32 other, Word32 result) {
        Word32.and(this,other,result);
    }

    public static void and(Word32 a, Word32 b, Word32 result) {
        for (int i = 0; i < 31; i++) {
            a.bits[i].and(b.bits[i],result.bits[i]);
        }
    }

    public void or(Word32 other, Word32 result) {
        Word32.or(this,other,result);
    }

    public static void or(Word32 a, Word32 b, Word32 result) {
        for (int i = 0; i < 31; i++) {
            a.bits[i].or(b.bits[i],result.bits[i]);
        }
    }

    public void xor(Word32 other, Word32 result) {
        Word32.xor(this,other,result);
    }

    public static void xor(Word32 a, Word32 b, Word32 result) {
        for (int i = 0; i < 31; i++) {
            a.bits[i].xor(b.bits[i],result.bits[i]);
        }
    }

    public void not(Word32 result) {
        Word32.not(this,result);
    }

    public static void not(Word32 a, Word32 result) {
        for (int i = 0; i < 31; i++) {
            a.bits[i].not(result.bits[i]);
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
