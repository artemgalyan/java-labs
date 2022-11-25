package lab10;

import lab10.iterators.RandomAccessIterable;
import lab10.iterators.RandomAccessIterator;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Stack<T> extends Collection<T> implements RandomAccessIterable<T> {
    private final ArrayList<T> data = new ArrayList<>();

    @Override
    protected ArrayList<T> getArrayList() {
        return data;
    }

    public T top() {
        if (isEmpty()) {
            throw new NoSuchElementException("The stack is empty");
        }
        return data.get(data.size() - 1);
    }

    public void push(T element) {
        data.add(element);
    }

    public void pop() throws IllegalOperationException {
        if (isEmpty()) {
            throw new IllegalOperationException("The stack is empty");
        }
        data.remove(0);
    }

    public void pushAll(Collection<? extends T> collection) {
        data.addAll(collection.getArrayList());
    }

    @Override
    public RandomAccessIterator<T> getIterator() {
        return new StackIterator();
    }

    public class StackIterator extends RandomAccessIterator<T> {
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
