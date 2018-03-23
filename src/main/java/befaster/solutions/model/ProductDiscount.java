package befaster.solutions.model;

public class ProductDiscount implements Discount {
    public ProductDiscount(int amount, SKU freeItem) {
    }

    @Override
    public int calculate(int forAmount) {
        return 0;
    }
}
