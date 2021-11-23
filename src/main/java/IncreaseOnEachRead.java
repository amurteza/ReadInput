import java.io.BufferedReader;
import java.io.FileReader;

import static java.lang.System.arraycopy;

public class IncreaseOnEachRead {
    public static void main(String[] args) throws Exception {
        User[] users = loadUsers(args[0]);
        System.out.println(users.length);
    }

    private static User[] loadUsers(String fileToReadFrom) throws Exception {
        User[] users = new User[0];

        BufferedReader lineReader = new BufferedReader(new FileReader(fileToReadFrom));
        try (CSVReader reader = new CSVReader(fileToReadFrom)) {
            String[] row;
            while ((row = reader.readRow()) != null) {
                User[] newUsers = new User[users.length + 1];
                arraycopy(users, 0, newUsers, 0, users.length );
                users = newUsers;
                //users[users.length - 1] = User.userFromRow(row);
            }
        }

        return users;
    }
}
