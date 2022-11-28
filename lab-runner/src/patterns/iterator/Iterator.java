package patterns.iterator;

public abstract class Iterator<T> {
    public abstract void next();
    public abstract void isDone();
    public abstract T getElement();
    public abstract void first();
}
