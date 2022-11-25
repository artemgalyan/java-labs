package lab6.generics;

import java.util.Arrays;

public class ArrayStack<E> {
  private E[] data  = (E[]) new Object[0];
  private Object[] objData = new Object[0];

  void push(E element) {
      data = Arrays.copyOf(data, data.length + 1);
      objData = Arrays.copyOf(objData, objData.length + 1);
      data[data.length - 1] = element;
      objData[objData.length - 1] = element;
  }
  E top() {
//       return (E)objData[0];
      return data[data.length - 1];
  }
  void pop() {
      objData = Arrays.copyOfRange(data, 0, data.length - 1);
      data = Arrays.copyOfRange(data, 0, data.length - 1);
  }
  boolean isEmpty() {
      return data.length == 0;
  }
}