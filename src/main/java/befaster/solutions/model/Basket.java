package befaster.solutions.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Basket {
    private final Pricing pricing;
    private final List<SKU> skuSkus;

    public Basket(final String skus, final Pricing pricing) {
        this.skuSkus = parseSkus(skus);
        this.pricing = pricing;
    }

    private List<SKU> parseSkus(String skus) {
        final StringTokenizer tokenizer = new StringTokenizer(skus, " ");
        final List<SKU> skuList = new ArrayList<>();
        while (tokenizer.hasMoreElements()) {
            skuList.add(SKU.skuOf(tokenizer.nextToken()));
        }
        return skuList;
    }

    public int calculateTotalDiscount() {
        final Map<SKU, Long> skusAndNumberOfItems = skuSkus
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return skusAndNumberOfItems.entrySet()
                .stream()
                .filter(entry -> !entry.getKey().hasDiscount() )
                .mapToInt(entry -> pricing.calculateDiscountFor(entry.getKey(), entry.getValue().intValue())
                ).sum();
    }

    public Integer totalCost() {
        return skuSkus.stream().mapToInt(pricing::priceFor).sum();
    }
}
