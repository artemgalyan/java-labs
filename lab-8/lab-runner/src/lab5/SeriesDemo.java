package lab5;

import tasks.Task;

public class SeriesDemo implements Task {

    private final double linearStart = 1;
    private final double linearD = 2;

    private final double expStart = 1;
    private final double expQ = 0.5;

    private final int sumTo = 10;

    @Override
    public void run() {
        Series linear = new Linear(linearStart, linearD);
        System.out.println("Linear series (start value - " + linearStart + ", d - " + linearD + "): " 
                + linear.toString());
        System.out.println("Linear sum to " + sumTo + ": " + linear.sumTo(sumTo));
        Series exp = new Exponential(expStart, expQ);
        System.out.println("Exponential series (start value - " + expStart + ", q - " + expQ + "): " 
                + exp.toString());
        System.out.println("Exponential sum to " + sumTo + ": " + exp.sumTo(sumTo));
    }
}
