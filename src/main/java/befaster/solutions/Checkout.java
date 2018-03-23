package befaster.solutions;

import java.util.StringTokenizer;

public class Checkout {
    public static Integer checkout(String skus) {
        final StringTokenizer tokenizer = new StringTokenizer(skus, " ");
        int cost = 0;
        while (tokenizer.hasMoreElements()) {
            tokenizer.nextToken();
            cost += 50;
        }
        return cost;
    }
}