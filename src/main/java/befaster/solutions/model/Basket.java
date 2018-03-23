package befaster.solutions.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Basket {
    private final Pricing pricing;
    private final List<SKU> skuList;
    private final DiscountCalculator discountCalculator;

    public Basket(final String skus, final Pricing pricing) {
        this.skuList = parseSkus(skus);
        this.pricing = pricing;
        this.discountCalculator = new DiscountCalculator(skuList);
    }

    private static List<SKU> parseSkus(String skus) {
        final List<SKU> skuList = new ArrayList<>();
        for (int index = 0; index < skus.length(); index++) {
            skuList.add(SKU.skuOf(skus.substring(index, index + 1), 50));
        }
        return skuList;
    }

    public int calculateTotalDiscount() {
        final Map<SKU, Long> skusAndNumberOfItems = skuList
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return discountCalculator.calculateDiscount(skusAndNumberOfItems);
    }

    public Integer totalCost() {
        return skuList.stream().mapToInt(pricing::priceFor).sum();
    }
}
