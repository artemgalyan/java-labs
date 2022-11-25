package lab10;

import lab10.iterators.InputIterator;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;

public class PriorityQueue<P extends Comparable<P>, T> extends Collection<PriorityQueue.PriorityPair<P, T>> {

    public static class PriorityPair<P extends Comparable<P>, T> implements Comparable<PriorityPair<P, T>> {
        private final P priority;
        private final T value;

        public PriorityPair(P priority, T value) {
            this.priority = priority;
            this.value = value;
        }

        public P getPriority() {
            return priority;
        }

        public T getValue() {
            return value;
        }

        @Override
        public int compareTo(@NotNull PriorityPair<P, T> o) {
            return priority.compareTo(o.priority);
        }
    }

//    public record PriorityPair<P extends Comparable<P>, T>(P priority,
//                                                           T value) implements Comparable<PriorityPair<P, T>> {
//
//        @Override
//            public int compareTo(@NotNull PriorityPair<P, T> o) {
//                return priority.compareTo(o.priority);
//            }
//        }

    private final ArrayList<PriorityPair<P, T>> data = new ArrayList<>();

    @Override
    protected ArrayList<PriorityPair<P, T>> getArrayList() {
        return data;
    }

    public void insert(T element, P priority) {
        data.add(new PriorityPair<>(priority, element));
    }

    public PriorityPair<P, T> extractMinimum() throws IllegalOperationException {
        if (data.isEmpty()) {
            throw new IllegalOperationException("The priority queue is empty");
        }
        PriorityPair<P, T> minimum = getMinimum();
        data.remove(minimum);
        return minimum;
    }

    public PriorityPair<P, T> getMinimum() {
        return data.stream()
                .min(Comparator.naturalOrder())
                .orElseThrow();
    }

    public void insertAll(Collection<PriorityPair<P, T>> collection) {
        data.addAll(collection.getArrayList());
    }

    @Override
    public InputIterator<PriorityPair<P, T>> getIterator() {
        return null;
    }

    public class PriorityQueueIterator extends InputIterator<PriorityPair<P, T>> {
        private int currentIndex = 0;
        @Override
        public PriorityPair<P, T> get() {
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
