package lab10;

import lab10.iterators.BidirectionalIterable;
import lab10.iterators.ForwardIterable;
import lab10.iterators.ForwardIterator;
import lab10.iterators.InputIterator;

import javax.swing.*;
import java.util.ArrayList;

public class Set<T> extends Collection<T> implements ForwardIterable<T> {
    private final ArrayList<T> data = new ArrayList<>();

    public Set() {
    }

    public Set(Collection<? extends T> collection) {
        addAll(collection);
    }

    @Override
    protected ArrayList<T> getArrayList() {
        return data;
    }

    public boolean add(T value) {
        if (data.contains(value)) {
            return false;
        }
        data.add(value);
        return true;
    }

    public boolean remove(T element) {
        return data.remove(element);
    }

    public boolean addAll(Collection<? extends T> c) {
        boolean result = true;
        InputIterator<? extends T> iterator = c.getIterator();
        while (iterator.hasElement()) {
            result &= add(iterator.get());
            iterator.next();
        }
        return result;
    }

    public boolean contains(T element) {
        return data.contains(element);
    }

    public Set<T> union(Set<? extends T> other) {
        Set<T> result = new Set<>(this);
        other.data.stream()
                .filter(e -> !this.contains(e))
                .forEach(result::add);
        return result;
    }

    public Set<T> intersect(Set<? extends T> other) {
        Set<T> result = new Set<>();
        other.data.stream()
                .filter(this::contains)
                .forEach(result::add);
        return result;
    }

    public Set<T> difference(Set<? extends T> other) {
        Set<T> result = new Set<>(this);
        other.data.stream()
                .filter(this::contains)
                .forEach(result::remove);
        return result;
    }

    @Override
    public ForwardIterator<T> getIterator() {
        return new SetIterator();
    }

    public class SetIterator extends ForwardIterator<T> {
        private int currentIndex = 0;

        @Override
        public T get() {
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
