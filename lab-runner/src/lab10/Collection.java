package lab10;

import lab10.iterators.InputIterable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Collection<T> implements InputIterable<T> {
    protected abstract ArrayList<T> getArrayList();

    public int size() {
        return getArrayList().size();
    }

    public boolean isEmpty() {
        return getArrayList().isEmpty();
    }

    public void clear() {
        getArrayList().clear();
    }

    @Override
    public String toString() {
        List<String> stringList = getArrayList().stream()
                .map(Object::toString).toList();
        return "[" + String.join(", ", stringList) + "]";
    }

    public DefaultListModel<T> toDefaultListModel() {
        DefaultListModel<T> listModel = new DefaultListModel<>();
        listModel.addAll(getArrayList());
        return listModel;
    }
}
