package lab10.iterators;

public abstract class InputIterator<T> {
    public abstract T get();
    public abstract void next();
    public abstract boolean hasNext();
    public abstract boolean hasElement();
}
