package lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class SeriesFileSaver {
    private final Series series;

    public SeriesFileSaver(Series series) {
        Objects.requireNonNull(series);
        this.series = series;
    }

    public void saveTo(File file) throws IOException {
        try (FileWriter writer = new FileWriter(file)) {
            writer.append(series.toString());
        }
    }

    public void saveTo(String path) throws FileNotFoundException, IOException {
        File file = new File(path);
        if (!file.exists())
            throw new FileNotFoundException(path);
        saveTo(file);
    }

    public void saveSumTo(File file, int to) throws IOException {
        try (FileWriter writer = new FileWriter(file)) {
            writer.append(Double.toString(series.sumTo(to)));
        }
    }

    public void saveSumTo(String path, int to) throws IOException {
        File file = new File(path);
        if (!file.exists())
            throw new FileNotFoundException(path);
        saveSumTo(file, to);
    }
}
