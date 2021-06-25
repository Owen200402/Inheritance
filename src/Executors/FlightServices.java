package Executors;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class FlightServices {
    public Stream<CompletableFuture<Quote>> getQuotes() {
        var sites = Stream.of("site1", "site2", "site3");

        return sites.map(this::getQuote);
    }

    private CompletableFuture<Quote> getQuote (String site) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting a quote from " + site);

            var random = new Random();

            LongTask.simulate(1000 + random.nextInt(2000));

            var price = 100 + random.nextInt(10);

            return new Quote(site, price);
        });
    }
}
