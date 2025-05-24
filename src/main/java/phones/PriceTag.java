package phones;

public class PriceTag extends Tag {
    private double price;

    public PriceTag(double price) {
        this.price = price;
    }

    @Override
    public boolean find(Phone ph) {
        return ph.getPrice() < price;
    }
}
