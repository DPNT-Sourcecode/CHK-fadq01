package befaster.solutions;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Checkout {
    public static Integer checkout(String skus) {
        final StringTokenizer checkoutScanner = new StringTokenizer(skus, " ");
        Integer cost = 0;
        while(checkoutScanner.hasMoreElements()){
            cost += 50;
        }
        return cost;
    }
}
