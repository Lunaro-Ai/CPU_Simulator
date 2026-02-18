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
        Bit temp = new Bit(false);
        Bit sum = new Bit(false);
        a.xor(b,temp);
        temp.xor(carryIn,sum);
        return sum;
    }

    public static Bit carryOut(Bit a, Bit b,Bit carryIn) {
        Bit t1,t2,t3,carryOut;
        t1 = new Bit(false);
        t2 = new Bit(false);
        t3 = new Bit(false);
        carryOut = new Bit(false);
        a.and(b,t1);
        a.xor(b,t2);
        t2.and(carryIn,t3);
        t1.or(t3,carryOut);
        return carryOut;
    }
}
