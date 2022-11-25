package lab10;

import lab10.iterators.BidirectionalIterable;
import lab10.iterators.BidirectionalIterator;
import lab10.iterators.RandomAccessIterable;
import lab10.iterators.RandomAccessIterator;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Queue<T> extends Collection<T> implements RandomAccessIterable<T> {
    private final ArrayList<T> data = new ArrayList<>();

    @Override
    protected ArrayList<T> getArrayList() {
        return data;
    }

    public T front() {
        if (data.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return data.get(0);
    }

    public T back() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return data.get(data.size() - 1);
    }

    public void push(T value) {
        data.add(value);
    }

    public void pop() throws IllegalOperationException {
        if (isEmpty()) {
            throw new IllegalOperationException("Queue is empty");
        }
        data.remove(0);
    }

    public void pushAll(Collection<? extends T> collection) {
        data.addAll(collection.getArrayList());
    }

    @Override
    public RandomAccessIterator<T> getIterator() {
        return new QueueIterator();
    }

    public class QueueIterator extends RandomAccessIterator<T> {
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

        @Override
        public void skipForward(int countOfElements) {
            currentIndex += countOfElements;
        }

        @Override
        public void skipBackwards(int countOfElements) {
            currentIndex -= countOfElements;
        }
    }
}
