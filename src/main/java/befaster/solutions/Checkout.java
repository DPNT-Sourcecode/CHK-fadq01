package befaster.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Checkout {
    private static final Map<String, Integer> priceTable = new HashMap<>();

    static {
        priceTable.put("A", 50);
        priceTable.put("B", 30);
        priceTable.put("C", 20);
        priceTable.put("D", 15);
    }

    public static Integer checkout(String skus) {
        final StringTokenizer tokenizer = new StringTokenizer(skus, " ");
        int cost = 0;
        while (tokenizer.hasMoreElements()) {
            cost += priceTable.get(tokenizer.nextToken());
        }
        return cost;
    }
}
