package patterns.strategy;

public interface Strategy<T, R> {
    R applyTo(T subject);
}
