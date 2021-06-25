package Projects;

public class Item {
    private final String item;
    private final int price;

    public Item(String item, Integer price) {
        this.item = item;
        this.price = price;
    }

    private String getItem() {
        return item;
    }

    private Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  "{Price for " + item +
                ": " + "$" + price + "}";
    }
}
