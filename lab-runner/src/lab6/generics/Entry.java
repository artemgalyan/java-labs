package lab6.generics;

public class Entry<K, V> {
    private final K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
    K getKey() {
        return key;
    }
    V getValue() {
        return value;
    }
    void setValue(V newValue) {
        value = newValue;
    }
}
