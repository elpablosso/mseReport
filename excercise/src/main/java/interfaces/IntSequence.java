package interfaces;

public class IntSequence {

    static NumberSequence of(int... numbers) {

        return new NumberSequence<Integer>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < numbers.length;
            }

            @Override
            public Integer next() {
                i++;
                return numbers[i - 1];
            }
        };
    }

    static NumberSequence constant(int value) {
        return (ConstSequence) () -> value;
    }

}