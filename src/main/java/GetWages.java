import java.io.IOException;
import java.util.Collections;
import java.util.Vector;

public class GetWages {
    public static void main(String[] args) throws IOException {
        Vector wages = new Vector();
        int sumWager = 0;
        int count = 0;

        try (CSVReader reader = new CSVReader("Adult_Data.csv")) {
            String[] row;

            while((row = reader.readRow()) != null) {
                String item = row[2].trim();
                if(item.length() > 0) {
                    count++;
                    sumWager += Integer.parseInt(item);
                    wages.add(Integer.parseInt(item));
                }
            }
        }

        Comparable minWager = Collections.min(wages);
        Comparable maxWager = Collections.max(wages);

        System.out.println(minWager.toString());
        System.out.println(maxWager.toString());
        System.out.println((sumWager / count));
        System.out.println(wages.size());
        System.out.println(count);
        System.out.println(sumWager);
   };
}

