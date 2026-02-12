/*
Rippler adder
 */


public class Adder {



    public static void subtract(Word32 a, Word32 b, Word32 result) {
    }

    public static void add(Word32 a, Word32 b, Word32 result) {

        // make a boolean function that takes 3 inputs x y carry-in and returns the sun and the carry-out



        Bit curA = new Bit(false);
        Bit curB = new Bit(false);
        Bit sum = new Bit(false);


        for (int i = 31; i >= 0; i--) {
            a.getBitN(i,curA);
            b.getBitN(i,curB);
            curA.xor(curB,sum);

        }

    }


}
