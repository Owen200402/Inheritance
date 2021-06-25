package Projects;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ItemTracer {
    public static void show() {
        var checker = new StatusChecker();

        StatusChecker.getPassword();

        DisplayBoard.shoppingDisplay();

        var start = LocalTime.now();

        var result = checker.getItems()
                .map(item -> item.thenAccept(System.out::println))
                .collect(Collectors.toList());

        CompletableFuture.allOf(result.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    System.out.println();
                    var end = LocalTime.now();
                    var duration = Duration.between(start, end);
                    System.out.println("Retrieved all items in " + duration.toMillis() + " msecs");
                });

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
