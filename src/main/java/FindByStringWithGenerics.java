import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

public class FindByStringWithGenerics {
    static int totalFound = 0;

    public static void main(String[] args) throws IOException {
        Vector<User> users = UsersLoader.loadUsersInVector(args[0]);
        System.out.printf("Loaded %d users.\n", users.size());
        System.out.print("Type a string to search for: ");
        try (Scanner usrInput = new Scanner(System.in)) {
            String toFind = usrInput.nextLine().toLowerCase();
            for (User user: users) {
                if (user.email.toLowerCase().contains(toFind) ||
                    user.name.toLowerCase().contains(toFind)) {
                    System.out.printf("Found user %s", user.name);
                    System.out.printf(" Email: %s\n", user.email);
                    totalFound++;
                }
            }

            if (totalFound == 0) {
                System.out.printf("No user found with string '%s'\n", toFind);
            } else {
                System.out.printf("Found %d users with '%s'\n", totalFound, toFind);
            }
        }
    }
}
