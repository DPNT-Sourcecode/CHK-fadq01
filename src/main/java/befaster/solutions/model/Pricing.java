package befaster.solutions.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Pricing {
    private static final Map<SKU, Integer> priceTable = new HashMap<>();

    static {
        priceTable.put(SKU.skuOf("A").withDiscount(new AmountDiscount(3, 20)), 50);
        priceTable.put(SKU.skuOf("B").withDiscount(new AmountDiscount(2, 45)), 30);
        priceTable.put(SKU.skuOf("C"), 20);
        priceTable.put(SKU.skuOf("D"), 15);
    }

    public int priceFor(SKU sku) {
        return priceTable.get(sku);
    }

    public int calculateDiscountFor(SKU key, int amount) {
        return findSkuFromMap(key).
                map(SKU::getAmountDiscount)
                .map(amountDiscount -> amountDiscount.calculate(amount)).orElse(0);
    }

    private Optional<SKU> findSkuFromMap(SKU key) {
        return priceTable.keySet()
                .stream()
                .filter(mapKey -> mapKey.equals(key))
                .findFirst();
    }
}