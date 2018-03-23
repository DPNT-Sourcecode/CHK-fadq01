package befaster.solutions.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
        return 20;
    }

    public Integer totalCost() {
        return skuSkus.stream().mapToInt(pricing::priceFor).sum();
    }
}
