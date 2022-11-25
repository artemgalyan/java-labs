package lab10.iterators;

public interface RandomAccessIterable<T> extends BidirectionalIterable<T> {
    RandomAccessIterator<T> getIterator();
}
