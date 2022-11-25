package lab10;

import lab10.iterators.InputIterator;

import java.util.ArrayList;

public class Map<K, V> extends Collection<Map.Entry<K, V>> {

    public static class Entry<K, V> {
        private final K key;
        private final V value;

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || obj.getClass() != getClass()) return false;
            Entry<?, ?> e = (Entry<?, ?>) obj;
            return key.equals(e.getKey());
        }
    }

    private final ArrayList<Entry<K, V>> data = new ArrayList<>();

    @Override
    protected ArrayList<Entry<K, V>> getArrayList() {
        return data;
    }

    public void put(Entry<K, V> entry) {
        data.remove(entry);
        data.add(entry);
    }

    public void put(K key, V value) {
        put(new Entry<>(key, value));
    }

    public Entry<K, V> get(K key) {
        return data.stream()
                .filter(e -> key.equals(e.getKey()))
                .findFirst()
                .orElseThrow();
    }

    public void putAll(Collection<? extends Entry<K, V>> collection) {
        InputIterator<? extends Entry<K, V>> iterator = collection.getIterator();
        while (iterator.hasElement()) {
            put(iterator.get());
            iterator.next();
        }
    }

    @Override
    public InputIterator<Entry<K, V>> getIterator() {
        return new MapIterator();
    }

    public class MapIterator extends InputIterator<Entry<K, V>> {

        private int currentIndex = 0;

        @Override
        public Entry<K, V> get() {
            return data.get(currentIndex);
        }

        @Override
        public void next() {
            ++currentIndex;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < data.size() - 1;
        }

        @Override
        public boolean hasElement() {
            return currentIndex < data.size();
        }
    }
}
