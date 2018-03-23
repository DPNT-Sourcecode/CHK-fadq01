package befaster.solutions.model;

import java.util.List;

public class ProductDiscount implements Discount {
    private final int amount;
    private final SKU freeItem;
    private final List<SKU> skuList;

    public ProductDiscount(int amount, SKU freeItem, List<SKU> skuList) {
        this.amount = amount;
        this.freeItem = freeItem;
        this.skuList = skuList;
    }

    @Override
    public int calculate(int forAmount) {
        return (forAmount / amount) * freeItem.getUnitPrice();
    }

    @Override
    public boolean applies() {
        return skuList.contains(freeItem);
    }
}
