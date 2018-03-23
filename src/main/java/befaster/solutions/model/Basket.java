package befaster.solutions.model;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Basket {
    private final Pricing pricing;
    private final List<SKU> skuList;

    public Basket(final List<SKU> skus, final Pricing pricing) {
        this.skuList = skus;
        this.pricing = pricing;
    }

    public int calculateTotalDiscount() {
        final Map<SKU, Long> skusAndNumberOfItems = skuList
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return skusAndNumberOfItems.entrySet()
                .stream()
                .filter(entry -> {
                    final SKU sku = entry.getKey();
                    return !sku.hasDiscount();
                })
                .mapToInt(entry -> {
                    final SKU sku1 = entry.getKey();
                    final Long amount = entry.getValue();

                    return sku1.calculateDiscount(amount.intValue());
                }).sum();
    }

    public Integer totalCost() {
        return skuList.stream().mapToInt(pricing::priceFor).sum();
    }
}
