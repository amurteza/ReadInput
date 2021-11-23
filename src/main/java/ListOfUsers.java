import java.io.IOException;
import java.util.Vector;

public class ListOfUsers {
    public static void main(String[] args) throws IOException {
        Vector users = new Vector();

        try (CSVReader reader = new CSVReader("users.csv")) {
            String[] row;

            while((row = reader.readRow()) != null) {
                User user = new User(Integer.parseInt(row[0]), row[1], row[2]);
                users.add(user);
            }
        }

        for(int i = 0; i < users.size(); i++) {
            User user = (User) users.get(i);
            System.out.println(user.name + " e-mail: " + user.email);
        }
    }
}
