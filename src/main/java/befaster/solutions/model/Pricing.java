package befaster.solutions.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Pricing {
    private final Map<SKU, List<SKU>> skuMap;

    public Pricing(List<SKU> skus) {
        this.skuMap = skus.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.reducing()));
    }

    public int priceFor(SKU sku) {
        if (!validSku(sku)) {
            throw new IllegalArgumentException("invalid sku");
        }
        return skuMap.get(sku);
    }

    private boolean validSku(SKU sku) {
        return skuMap.containsKey(sku);
    }

    public int calculateDiscountFor(SKU key, int amount) {
        return findSkuFromMap(key).
                map(SKU::getDiscount)
                .map(amountDiscount -> amountDiscount.calculate(amount))
                .orElse(0);
    }

    private Optional<SKU> findSkuFromMap(SKU key) {
        return skuMap.keySet()
                .stream()
                .filter(mapKey -> mapKey.equals(key))
                .findFirst();
    }
}
