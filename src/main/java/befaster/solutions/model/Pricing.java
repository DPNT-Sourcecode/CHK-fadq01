package befaster.solutions.model;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Pricing {
    private final Map<SKU, List<SKU>> skuMap;

    public Pricing(List<SKU> skus) {
        this.skuMap = skus.stream().collect(Collectors.groupingBy(Function.identity()));
    }

    public int priceFor(SKU sku) {
        if (!validSku(sku)) {
            throw new IllegalArgumentException("invalid sku");
        }
        return skuMap.get(sku).stream().findFirst().get().getUnitPrice();
    }

    private boolean validSku(SKU sku) {
        return skuMap.containsKey(sku);
    }

    public int calculateDiscountFor(SKU key, int amount) {
        final Optional<List<Discount>> optionalDiscountList = findSkuFromMap(key).
                map(SKU::getDiscounts);
        return optionalDiscountList.map(discountList ->
                discountList.stream().mapToInt(discount -> discount.calculate(amount)).sum()
        ).orElse(0);
    }

    private Optional<SKU> findSkuFromMap(SKU key) {
        return skuMap.keySet()
                .stream()
                .filter(mapKey -> mapKey.equals(key))
                .findFirst();
    }
}
