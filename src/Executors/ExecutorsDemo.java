package Executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ExecutorsDemo {
    public static void show() {
        var executor = Executors.newFixedThreadPool(3);

        try {
            var future = executor.submit(() -> 1);

            System.out.println("More work please!");

            try {
                var result = future.get();
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            }
        }
        finally {
            executor.shutdown();
        }
    }
}