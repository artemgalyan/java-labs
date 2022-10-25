package lab5;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;

public abstract class Counters {
    private Counters() {}

    public static <T> boolean contains(T[] array, T value) {
        return Arrays.asList(array).contains(value);
    } 

    public static <T> long countEqualElements(T[] array, T value) {
        return Arrays.stream(array).filter(v -> v.equals(value)).count();
    }

    public static <T extends Comparable<T>> long countGreaterElements(T[] array, T value) {
        return Arrays.stream(array).filter(v -> v.compareTo(value) < 0).count();
    }

    public static <T> long countIf(T[] array, Predicate<T> pred) {
        return Arrays.stream(array).filter(pred).count();
    }

    public static <T extends Number> Number sum(T[] array) {
        if (array.length == 0) {
            return 0;
        }
        Number first = array[0];
        if (first instanceof Integer || first instanceof AtomicInteger || first instanceof Byte) {
            return Arrays.stream(array).mapToInt(Number::intValue).sum();
        }
        if (first instanceof Double || first instanceof Float) {
            return Arrays.stream(array).mapToDouble(Number::doubleValue).sum();
        }
        if (first instanceof Long || first instanceof AtomicLong) {
            return Arrays.stream(array).mapToLong(Number::longValue).sum();
        }
        if (first instanceof BigInteger) {
            BigInteger result = BigInteger.ZERO;
            for (Number n: array) {
                result = result.add((BigInteger)n);
            }
            return result;
        }
        if (first instanceof BigDecimal) {
            BigDecimal result = BigDecimal.ZERO;
            for (Number n: array) {
                result = result.add((BigDecimal) n);
            }
            return result;
        }
        return Arrays.stream(array).mapToLong(Number::longValue).sum();
    }
}
