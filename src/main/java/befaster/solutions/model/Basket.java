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
      return skuList.stream().mapToInt(SKU::calculateDiscount).sum();
    }

    public Integer totalCost() {
        return skuList.stream().mapToInt(pricing::priceFor).sum();
    }
}
