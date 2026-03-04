public class Memory {

    public Word32 address = new Word32();
    public Word32 value = new Word32();

    private final Word32[] dram = new Word32[1000];

    public int addressAsInt() {
       int value = 1;
       int rval = 0;
       Bit c = new Bit(false);
        for (int i = 31; i >= 0 ; i--) {
            address.getBitN(i,c);
            if (c.getValue()) rval+=value;
            value*=2;
        }
        return rval;
    }


    public Memory() {
        for (int i = 0; i < 1000; i++) {
            dram[i] = new Word32();
        }
    }

    public void read() {
        dram[addressAsInt()].copy(value);
    }

    public void write() {

        value.copy(dram[addressAsInt()]);

    }

    public void load(String[] data)  {

        for (int i = 0; i < 1000; i++) {
            if (data[i].length() != 32) {
                throw new IndexOutOfBoundsException();
            }
            for (int j = 0; j < 32; j++) {
                if (data[i].charAt(j) == '1')  dram[i].setBitN(j,new Bit(true));
                else dram[i].setBitN(j,new Bit(false));
            }
        }
    }
}
