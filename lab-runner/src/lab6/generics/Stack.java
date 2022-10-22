package lab6.generics;

import java.util.ArrayList;

public class Stack<E> {
    private ArrayList<E> data = new ArrayList<>();

    public Stack() {};
    void push(E element) {
        data.add(element);
    }
    E top() {
        return data.get(data.size() - 1);
    }
    void pop() {
        data.remove(data.size() - 1);
    }
    boolean isEmpty() {
        return data.isEmpty();
    }
}
