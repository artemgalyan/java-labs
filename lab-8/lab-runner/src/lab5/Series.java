package lab5;

public abstract class Series {
    public static final int TO_STRING_COUNT = 10;
    public abstract double elementAt(int index);
    public double sumTo(int index) {
        if (index < 1) {
            throw new IndexOutOfBoundsException();
        }
        double result = 0;
        for (int i = 1; i <= index; ++i)
            result += elementAt(i);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Series: ");
        for (int i = 1; i <= TO_STRING_COUNT; ++i) {
            sb.append(elementAt(i));
            if (i != TO_STRING_COUNT)
                sb.append(',').append(' ');
        }
        return sb.toString();

    }
}
