package lab10.iterators;

public abstract class BidirectionalIterator<T> extends ForwardIterator<T> {
    public abstract boolean hasPrevious();
    public abstract void previous();
}
