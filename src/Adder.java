/*
Rippler adder
 */
public class Adder {

    public static void subtract(Word32 a, Word32 b, Word32 result) {
        Word32 negation = new Word32();
        b.not(negation);
        Word32 one = new Word32();
        one.setBitN(31,new Bit(true));
        Word32 compliment = new Word32();
        add(negation,one,compliment);
        add(a,compliment,result);
    }

    public static void add(Word32 a, Word32 b, Word32 result) {
        Bit currA,currB,carryIn;
        currA = new Bit(false);
        currB = new Bit(false);
        carryIn = new Bit(false);
        for (int i = 31; i >= 0; i--) {
            a.getBitN(i,currA);
            b.getBitN(i,currB);
            Bit sumBit = sum(currA,currB,carryIn);
            result.setBitN(i,sumBit);
            carryIn = carryOut(currA,currB,carryIn);
        }
    }

    public static Bit sum(Bit a, Bit b, Bit carryIn) {
        Bit result = new Bit(false);
        Bit sum = new Bit(false);
        a.xor(b,result);
        result.xor(carryIn,sum);
        return sum;
    }

    public static Bit carryOut(Bit a, Bit b,Bit carryIn) {
        Bit r1, r2, r3,carryOut;
        r1 = new Bit(false);
        r2 = new Bit(false);
        r3 = new Bit(false);
        carryOut = new Bit(false);
        a.and(b, r1);
        a.xor(b, r2);
        r2.and(carryIn, r3);
        r1.or(r3,carryOut);
        return carryOut;
    }
}
