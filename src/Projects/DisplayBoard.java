package Projects;

import Executors.LongTask;
import generics.PasswordGenerator;

import java.util.Scanner;

public class DisplayBoard {
    public static void shoppingDisplay() {
        System.out.println("Checking for the status of your items in your shopping car...");

        LongTask.simulate(1000);

        System.out.println("Please wait patiently.");
        System.out.println();

        LongTask.simulate(2000);

        System.out.println("Here's your shopping detail: ");
    }

    public static void passwordDisplay() {
        var generator = new PasswordGenerator();
        var scanner = new Scanner(System.in);

            System.out.println("This account has been verified.");

            LongTask.simulate(1000);

            System.out.println("Do you want to generate a strong and safe password for Owen's Online Shopping platform?" +
                    " Enter 'yes' or 'no'.");

        while(true) {
            var read = scanner.next();
            if (read.equals("yes") | read.equals("Yes")) {
                    var result = generator.generateRandomPassword();
                    System.out.println("Here's your password: ");
                    System.out.println(result);
                    System.out.println();
                    LongTask.simulate(2000);
                    break;
                }
                else if (read.equals("no") | read.equals("No")) {
                    break;
                }
                else {
                    System.out.println("Please enter 'yes' or 'no'!");
            }
        }
    }
}
