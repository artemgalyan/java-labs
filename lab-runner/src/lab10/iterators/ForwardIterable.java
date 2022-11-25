package lab10.iterators;

public interface ForwardIterable<T> extends InputIterable<T> {
    ForwardIterator<T> getIterator();
}
