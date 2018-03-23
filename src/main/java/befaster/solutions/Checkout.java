package befaster.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Checkout {


    public static Integer checkout(String skus) {
        final Pricing pricing = new Pricing();
        final StringTokenizer tokenizer = new StringTokenizer(skus, " ");
        int cost = 0;
        while (tokenizer.hasMoreElements()) {
            cost += pricing.priceFor(tokenizer.nextToken());
        }
        return cost;
    }

    private static class Pricing {
        private static final Map<String, Integer> priceTable = new HashMap<>();

        static {
            priceTable.put("A", 50);
            priceTable.put("B", 30);
            priceTable.put("C", 20);
            priceTable.put("D", 15);
        }

        int priceFor(String sku) {
            return priceTable.get(sku);
        }
    }
}