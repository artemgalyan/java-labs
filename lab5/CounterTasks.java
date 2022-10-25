package lab5;

import java.util.Arrays;

import tasks.Task;
import utils.ScannerPool;

public class CounterTasks implements Task {

    @Override
    public void run() {
        Integer[] intArray = {1, 2, 3, 4, 5, 3};
        System.out.println("Array: " + Arrays.toString(intArray));
        var scanner = ScannerPool.get(System.in);
        System.out.println("Input number: ");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println("Source array contains " + number + ": " + Counters.contains(intArray, number));
        System.out.println("Count of 3 is " + Counters.countEqualElements(intArray, 3));
        System.out.println("Count of numbers that >3 is " + Counters.countGreaterElements(intArray, 3));
        System.out.println("Count of even numbers is " + Counters.countIf(intArray, i -> i % 2 == 0));
        System.out.println("Sum is " + Counters.sum(intArray));
        Double[] doubleArray = {1.5, 2.3, 1.4, 2.1};
        System.out.println("Sum of " + Arrays.toString(doubleArray) + " is " + Counters.sum(doubleArray));
        tryAgain();
    }
    
}
