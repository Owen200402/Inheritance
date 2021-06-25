package Executors;

public class Quote {
    private final String site;
    private final int price;

    public Quote(String site, int price) {
        this.site = site;
        this.price = price;
    }

    private String getSite() {
        return site;
    }

    private int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "site='" + site + '\'' +
                ", price=" + price +
                '}';
    }
}
