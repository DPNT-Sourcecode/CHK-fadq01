package befaster.solutions.model;

import java.util.ArrayList;
import java.util.List;

public class SkuParser {
    public static List<SKU> parseSkus(String skus) {
        final List<SKU> skuList = new ArrayList<>();
        for (int index = 0; index < skus.length(); index++) {
            skuList.add(SKU.skuOf(skus.substring(index, index + 1), 50));
        }
        return skuList;
    }
}
