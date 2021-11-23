import java.io.*;

public class MyReadCSVFile {
    public static void main(String[] args) throws FileNotFoundException {
        String file = args[0];

        FileReader fileReader = new FileReader(file);
        try(BufferedReader reader = new BufferedReader(fileReader)) {
            String line;
            int lineNumber = -1;

            while((line = reader.readLine()) != null) {
                lineNumber++;
                if (lineNumber == 0)
                    continue;

                String[] split = line.split(";");
                System.out.printf("%d - %s\n", lineNumber, split[2]);
            }

            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
