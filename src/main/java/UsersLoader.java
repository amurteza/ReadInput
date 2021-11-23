import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

public class UsersLoader {
    public static Vector<User> loadUsersInVector(String pathToFile) throws IOException {
        Vector<User> users = new Vector();
        String[] row;

        try (CSVReader reader = new CSVReader(pathToFile)) {
            while((row = reader.readRow()) != null) {
                users.add(User.fromValues(row));
            }
        }

        return users;
    }

    public static Hashtable<String, User> loadUsersInHashtableByEmail(String pathToFile) throws IOException {
        Hashtable<String, User> users = new Hashtable();

        try (CSVReader reader = new CSVReader(pathToFile)) {
            String[] row = null;
            while((row = reader.readRow()) != null) {
                User user = User.fromValues(row);
                users.put(user.email, user);
            }
        }

        return users;
    }
}
