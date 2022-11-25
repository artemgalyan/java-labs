package lab10;

import lab10.iterators.BidirectionalIterable;
import lab10.iterators.BidirectionalIterator;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Deque<T> extends Collection<T> implements BidirectionalIterable<T> {
    private final ArrayList<T> data = new ArrayList<>();

    @Override
    protected ArrayList<T> getArrayList() {
        return data;
    }

    public T front() {
        if (isEmpty()) {
            throw new NoSuchElementException("The deque is empty");
        }
        return data.get(0);
    }

    public T back() {
        if (isEmpty()) {
            throw new NoSuchElementException("The deque is empty");
        }
        return data.get(data.size() - 1);
    }

    public void pushBack(T element) {
        data.add(element);
    }

    public void pushFront(T element) {
        data.add(0, element);
    }

    public void popFront() throws IllegalOperationException {
        if (isEmpty()) {
            throw new IllegalOperationException("The deque is empty");
        }
        data.remove(0);
    }

    public void popBack() throws IllegalOperationException {
        if (isEmpty()) {
            throw new IllegalOperationException("The deque is empty");
        }
        data.remove(data.size() - 1);
    }

    public void pushFrontAll(Collection<? extends T> collection) {
        data.addAll(0, collection.getArrayList());
    }

    public void pushBackAll(Collection<? extends T> collection) {
        data.addAll(collection.getArrayList());
    }

    @Override
    public BidirectionalIterator<T> getIterator() {
        return new DequeIterator();
    }

    public class DequeIterator extends BidirectionalIterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasPrevious() {
            return currentIndex > 0;
        }

        @Override
        public void previous() {
            --currentIndex;
        }

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
            return currentIndex >= 0 && currentIndex < data.size();
        }
    }
}
