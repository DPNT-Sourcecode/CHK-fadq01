package befaster.solutions.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SKU {

    private final String skuName;
    private final int unitPrice;
    private List<Discount> discounts = new ArrayList<>();

    private SKU(String skuName, int unitPrice) {
        this.skuName = skuName;
        this.unitPrice = unitPrice;
    }

    public static SKU skuOf(String name, int unitPrice) {
        return new SKU(name, unitPrice);
    }

    public SKU withDiscount(Discount amountDiscount) {
        discounts.add(amountDiscount);
        return this;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int calculateDiscount() {
        return discounts.stream()
                .filter(Discount::applies)
                .mapToInt(discount -> discount.calculate(amount))
                .max()
                .orElse(0);

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

}
