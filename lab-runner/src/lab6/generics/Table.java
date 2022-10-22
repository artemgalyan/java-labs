package lab6.generics;

import java.util.ArrayList;

public class Table<K, V> {
    private final ArrayList<Entry<K, V>> data = new ArrayList<>();
    public class MyEntry {
        private final K key;
        private V value;

        public MyEntry(K key, V value) {
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

    void add(K key, V value) {
        if (data.stream().anyMatch(e -> e.getKey().equals(key))) {
            throw new IllegalArgumentException("There is already argument with key " + key);
        }
        data.add(new Entry<>(key, value));
    }
    V getValue(K key) {
        for (Entry<K, V> entry: data) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }
    boolean remove(K key) {
        for (Entry<K, V> entry: data) {
            if (entry.getKey().equals(key)) {
                data.remove(entry);
                return true;
            }
        }
        return false;
    }

}