package lab10.iterators;

public abstract class RandomAccessIterator<T> extends BidirectionalIterator<T> {
    public abstract void skipForward(int countOfElements);
    public abstract void skipBackwards(int countOfElements);
}
