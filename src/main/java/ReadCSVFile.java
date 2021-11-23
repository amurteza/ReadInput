import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVFile {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = args[0];

        FileReader fileReader = new FileReader(fileName);
        try(BufferedReader reader = new BufferedReader(fileReader)) {
            String line;
            int lineCounter = -1;

            while((line = reader.readLine()) != null) {
                lineCounter++;
                if(lineCounter == 0)
                    continue;

                String[] split = line.split(";");
                System.out.printf("%d - %s\n",lineCounter, split[2]);
            }

            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
