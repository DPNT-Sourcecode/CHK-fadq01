package befaster.solutions.model;

import java.util.Objects;

public class SKU {

    private final String skuName;
    private AmountDiscount amountDiscount;

    private SKU(String skuName) {
        this.skuName = skuName;
    }

    public static SKU skuOf(String name) {
        return new SKU(name);
    }

    public SKU withDiscount(AmountDiscount amountDiscount) {
        this.amountDiscount = amountDiscount;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SKU sku = (SKU) o;
        return Objects.equals(skuName, sku.skuName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(skuName);
    }

    public AmountDiscount getAmountDiscount() {
        return amountDiscount;
    }

    public boolean hasDiscount() {
        return amountDiscount != null;
    }
}
