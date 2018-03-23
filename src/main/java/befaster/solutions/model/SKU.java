package befaster.solutions.model;

import java.util.Objects;

public class SKU {

    private final String skuName;
    private static int unitPrice;
    private Discount discount;

    private SKU(String skuName) {
        this.skuName = skuName;
    }

    public static SKU skuOf(String name, int unitPrice) {
        SKU.unitPrice = unitPrice;
        return new SKU(name);
    }

    public SKU withDiscount(Discount amountDiscount) {
        this.discount = amountDiscount;
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

    public Discount getDiscount() {
        return discount;
    }

    public boolean hasDiscount() {
        return discount != null;
    }
}
