import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader implements Closeable {
    private final BufferedReader reader;
    private int lineCount = 0;
    private String[] header;

    public CSVReader(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        this.reader = new BufferedReader(fileReader);

        // Get header
        header = reader.readLine().split(";");
    }

    public void close() throws IOException {
        this.reader.close();
    }

    public String[] readRow() throws IOException {
        String line = reader.readLine();
        if (line == null) {
            close();
            return null;
        }

        lineCount++;

        return line.split(",");
    }

    public int getLineCount() {
        return lineCount;
    }

    public String[] getHeader() {
        return header;
    }
}
