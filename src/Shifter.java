public class Shifter {


    public static void LeftShift(Word32 source, int amount, Word32 result) {
        for (int i = 31; i >= 0; i--) {
            int rA = amount % 32;
            int index = i-rA;
            Bit current = new Bit(false);
            source.getBitN(i, current);
            if (index >= 0) result.setBitN(index, current);
        }
    }
    public static void RightShift(Word32 source, int amount, Word32 result) {
        for (int i = 0; i < 32; i++) {
            int rA = amount%32;
            int index = i+rA;
            Bit current = new Bit(false);
            source.getBitN(i, current);
            if (index <= 31) result.setBitN(index,current);
        }
    }
}
