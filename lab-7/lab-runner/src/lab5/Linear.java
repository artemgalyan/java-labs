package lab5;

public class Linear extends Series {
    private final double startValue;

    private final double diff;

    public Linear(double startValue, double diff) {
        this.startValue = startValue;
        this.diff = diff;
    }

    @Override
    public double elementAt(int index) {
        return startValue + (diff * (index - 1));
    }
}
