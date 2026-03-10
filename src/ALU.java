public class ALU {
    public Word16 instruction = new Word16();
    public Word32 op1 = new Word32();
    public Word32 op2 = new Word32();
    public Word32 result = new Word32();
    public Bit less = new Bit(false);
    public Bit equal = new Bit(false);

    public void doInstruction() {
        int code = getOp();
        if (code == 1) Adder.add(op1, op2, result);
        else if (code == 2) op1.and(op2, result);
        else if (code == 3) Multiplier.multiply(op1, op2, result);
        else if (code == 4) {
            int shift = fiveLowestBits(op2);
            Shifter.LeftShift(op1, shift, result);
        }
        else if (code == 5) Adder.subtract(op1,op2,result);
        else if (code == 6) op1.or(op2,result);
        else if (code == 7) {
            int shift = fiveLowestBits(op2);
            Shifter.RightShift(op1,shift,result);
        }
        else if (code == 11) {
            Adder.subtract(op1,op2,result);
            int res = wordToInt(result);
            less.assign(false);
            equal.assign(false);
            if (res == 0) {
                equal.assign(true);
            } else if (res<0) {
                less.assign(true);
            } else {
                less.assign(false);
            }
        }

    }


    public int getOp() {
        int val = 1;
        int rval = 0;
        Bit c = new Bit(true);
        for (int i = 4; i >= 0; i--) {
            instruction.getBitN(i, c);
            if (c.getValue()) rval += val;
            val *= 2;
        }
        return rval;
    }

    public int wordToInt(Word32 word) {
        int val = 1;
        int rval = 0;
        Bit c = new Bit(true);
        for (int i = 31; i >= 0; i--) {
            word.getBitN(i, c);
            if (c.getValue()) rval += val;
            val *= 2;
        }
        return rval;
    }

    public int fiveLowestBits(Word32 word) {
        int postion = 1;
        int shiftAmount = 0;
        Bit c = new Bit(true);
        for (int i = 31; i >= 27; i--) {
            word.getBitN(i, c);
            if (c.getValue()) shiftAmount += postion;
            postion *= 2;
        }
        return shiftAmount;
    }
}

