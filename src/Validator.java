/**
 * Created by Ny Derry on 7/14/2017.
 * GIT COMMIT VCS
 */
import java.util.Scanner;

public class Validator {

        public static String getString(Scanner entry, String prompt) {
            System.out.print(prompt);
            String userEntry = entry.next();    // read user entry
            entry.nextLine();                  // discard any other data entered on the line
            return userEntry;
        }

        public static String getString(Scanner entry, String prompt, String invalidPrompt, String valid1, String valid2) {
            boolean isValid = false;
            String userEntry = "";
            while (isValid == false) {
                System.out.print(prompt);
                userEntry = entry.next();     // read user entry
                entry.nextLine();            // discard any other data entered on the line
                if (userEntry.equalsIgnoreCase(valid1) || userEntry.equalsIgnoreCase(valid2)) {
                    isValid = true;
                } else {
                    System.out.print(invalidPrompt);
                }
            }
            return userEntry;
        }

        public static String getString(Scanner entry, String prompt, String invalidPrompt, String valid1, String valid2, String valid3) {
            boolean isValid = false;
            String userEntry = "";
            while (isValid == false) {
                System.out.print(prompt);
                userEntry = entry.next();    // read user entry
                entry.nextLine();            // discard any other data entered on the line
                if (userEntry.equalsIgnoreCase(valid1) || userEntry.equalsIgnoreCase(valid2) || userEntry.equalsIgnoreCase(valid3)) {
                    isValid = true;
                } else {
                    System.out.print(invalidPrompt);
                }
            }
            return userEntry;
        }

        public static int getInt(Scanner entry, String prompt) {
            int i = 0;
            boolean isValid = false;
            while (isValid == false) {
                System.out.print(prompt);
                if (entry.hasNextInt()) {
                    i = entry.nextInt();
                    isValid = true;
                } else {
                    System.out.println("Error! Invalid integer value. Try again.");
                }
                entry.nextLine();   // discard any other data entered on the line
            }
            return i;
        }

        public static int getInt(Scanner entry, String prompt, String invalidPrompt, int min, int max) {
            int i = 0;
            boolean isValid = false;
            while (isValid == false) {
                i = getInt(entry, prompt);
                if (i < min)
                    System.out.print(invalidPrompt);
                else if (i > max)
                    System.out.print(invalidPrompt);
                else
                    isValid = true;
            }
            return i;
        }

    }
