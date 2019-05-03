package interfaces;

import java.math.BigInteger;

public class SquareSequence implements NumberSequence<BigInteger> {

    BigInteger i = BigInteger.ZERO;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public BigInteger next() {
        i=i.add(BigInteger.ONE);
        return i.pow(2);
    }
}
