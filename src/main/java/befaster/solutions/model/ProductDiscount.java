package befaster.solutions.model;

public class ProductDiscount implements Discount {
    private final int amount;
    private final SKU freeItem;

    public ProductDiscount(int amount, SKU freeItem) {
        this.amount = amount;
        this.freeItem = freeItem;
    }

    @Override
    public int calculate(int forAmount) {
        return (forAmount / amount) * freeItem.getUnitPrice();
    }
}
