package befaster.solutions.model;

import java.util.HashMap;
import java.util.Map;

public class Pricing {
    private static final Map<SKU, Integer> priceTable = new HashMap<>();

    static {
        priceTable.put(SKU.skuOf("A").withDiscount(new AmountDiscount(3, 20)), 50);
        priceTable.put(SKU.skuOf("B"), 30);
        priceTable.put(SKU.skuOf("C"), 20);
        priceTable.put(SKU.skuOf("D"), 15);
    }

    public int priceFor(SKU sku) {
        return priceTable.get(sku);
    }

}
