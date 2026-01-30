public class Word32 {

    private Bit[] bits;

    public Word32() {
        bits = new Bit[32];
    }

    public Word32(Bit[] in) {
        this.bits = in;
    }

    public void getTopHalf(Word16 result) { // sets result = bits 0-15 of this word. use bit.assign
        for (int i = 0; i < 16; i++) {
            result.setBitN(i,bits[i]);
        }
    }

    public void getBottomHalf(Word16 result) { // sets result = bits 16-31 of this word. use bit.assign
        for (int i = 0; i < 16; i++) result.setBitN(i,bits[(bits.length-1)-i]);
    }

    public void copy(Word32 result) { // sets result's bit to be the same as this. use bit.assign
        // Might need to use bit.assign!!!
        for (int i = 0; i < bits.length; i++) result.bits[i] = bits[i];

    }

    public boolean equals(Word32 other) {
        Word32 current = new Word32(bits);
        return Word32.equals(current, other);
    }

    public static boolean equals(Word32 a, Word32 b) {
        for (int i = 0; i < 16; i++) {
            if (a.bits[i].getValue() != b.bits[i].getValue()) {
                return false;
            }
        }
        return true;
    }

    public void getBitN(int n, Bit result) { // use bit.assign
        Bit current = bits[n];
        result.assign(current.getValue());
    }

    public void setBitN(int n, Bit source) { //  use bit.assign
    }

    public void and(Word32 other, Word32 result) {
        Word32 current = new Word32(bits);
        Word32.and(current,other,result);
    }

    public static void and(Word32 a, Word32 b, Word32 result) {

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

    public void or(Word32 other, Word32 result) {
        Word32 current = new Word32(bits);
        Word32.or(current,other,result);

    }

    public static void or(Word32 a, Word32 b, Word32 result) {
        for (int i = 0; i < 16; i++) {
            if (!a.bits[i].getValue()) {
                if (!b.bits[i].getValue()) result.bits[i] = new Bit(false);
            } else result.bits[i] = new Bit(true);

        }
    }

    public void xor(Word32 other, Word32 result) {
        Word32 current = new Word32(bits);
        Word32.xor(current,other,result);
    }

    public static void xor(Word32 a, Word32 b, Word32 result) {
        for (int i = 0; i < 16; i++) {
            if (a.bits[i].getValue() == b.bits[i].getValue()) result.bits[i] = new Bit(false);
            else result.bits[i]= new Bit(true);
        }
    }

    public void not(Word32 result) {
        Word32 current = new Word32(bits);
        Word32.not(current,result);
    }

    public static void not(Word32 a, Word32 result) {
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
