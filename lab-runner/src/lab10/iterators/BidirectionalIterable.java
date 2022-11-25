package lab10.iterators;

public interface BidirectionalIterable<T> extends ForwardIterable<T> {
    BidirectionalIterator<T> getIterator();
}
