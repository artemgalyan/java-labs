package lab4;

public class TimeDuration extends Number implements Comparable<TimeDuration> {
    private int duration;

    public TimeDuration(int duration) {
        this.duration = duration;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public int intValue() {
        return duration;
    }

    @Override
    public long longValue() {
        return duration;
    }

    @Override
    public float floatValue() {
        return duration;
    }

    @Override
    public double doubleValue() {
        return duration;
    }

    @Override
    public String toString() {
        return "TimeDuration{" +
                "duration=" + duration +
                '}';
    }

    @Override
    public int compareTo(TimeDuration o) {
        return duration - o.duration;
    }
}
