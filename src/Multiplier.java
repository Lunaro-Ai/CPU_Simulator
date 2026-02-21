public class Multiplier {
    public static void multiply(Word32 a, Word32 b, Word32 result) {

        Bit currB = new Bit(false);
        int bitPosition = 0;
        Word32 temp = new Word32();
        Word32 sum = new Word32();
        Word32 zero = new Word32();
        for (int i = 31; i >= 0; i--) {
            b.getBitN(i,currB);
            if (currB.getValue()) {
                Shifter.LeftShift(a,bitPosition,temp);
                Adder.add(temp,sum,sum);
                zero.copy(temp);
            }
            bitPosition++;
        }
        sum.copy(result);
    }
}
