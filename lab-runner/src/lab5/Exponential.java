package lab5;

public class Exponential extends Series {
    private final double startValue;
    private final double q;

    public Exponential(double startValue, double q) {
        this.startValue = startValue;
        this.q = q;
    }

    @Override
    public double elementAt(int index) {
        return startValue * Math.pow(q, index - 1);
    }
}
