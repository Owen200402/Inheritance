package Executors;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFutureDemo {
    public static void show() {
        var start = LocalTime.now();

        var service = new FlightServices();
        var future = service.getQuotes()
                .map(quotes -> quotes.thenAccept(System.out::println))
                .collect(Collectors.toList());

        CompletableFuture.allOf(future.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    var end = LocalTime.now();
                    var duration = Duration.between(start, end);
                    System.out.println("Retrieved all quotes in " + duration.toMillis() + " msecs");
                });

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
