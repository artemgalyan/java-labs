package lab9;

public interface Strategy<T, R> {
    R apply(T object);
}
