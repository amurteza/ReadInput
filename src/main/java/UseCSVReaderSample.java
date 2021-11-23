import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class UseCSVReaderSample {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];

        try (CSVReader csvReader = new CSVReader(fileName)) {
            String[] row;

            for (String head: csvReader.getHeader()) {
                System.out.printf("[%s]", head);
            }
            System.out.println("");

            while((row = csvReader.readRow()) != null) {
                System.out.printf("%d - %s\n", csvReader.getLineCount(), row[2]);
            }
        }
    }
}
