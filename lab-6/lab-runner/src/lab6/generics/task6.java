package lab6.generics;

import java.util.Arrays;

public class task6 {
    @SafeVarargs
    public static <T> T[] swap(int i, int j, T... values) {
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        return values;
    }

    public static void main(String[] args) {
        Double[] result = task6.swap(0, 1, 1.5, 2.0);
        System.out.println(Arrays.toString(result));
    }
}