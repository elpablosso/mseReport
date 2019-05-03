package interfaces;

public interface ConstSequence extends NumberSequence {

    @Override
    default boolean hasNext() {
        return true;
    }
}
