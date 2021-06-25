package Projects;

import Executors.LongTask;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Stream;

public class StatusChecker {
    public Stream<CompletableFuture<Item>> getItems() {
        var items = Stream.of("item1", "item2", "item3");
        return items.map(this::getItem);
    }

    public CompletableFuture<Item> getItem(String item) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Your " + item + " is packaged and ready to be delivered.");

            var random = new Random();

            int price = 100 + random.nextInt(100);

            LongTask.simulate(2000 + random.nextInt(2000));

            return new Item(item, price);
        });
    }

    public static void getPassword() {
        var scanner =  new Scanner(System.in);

        while(true) {
            System.out.println("Enter your email address: ");
            var read = scanner.next();
            if(read.contains("@") & read.contains(".com") & read.length() > 15) {
                break;
            }
            System.out.println("Your email address is not valid");
        }

        DisplayBoard.passwordDisplay();
    }
}
