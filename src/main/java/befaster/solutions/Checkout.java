package befaster.solutions;

import befaster.solutions.model.*;
import com.google.common.collect.ImmutableList;

import java.util.List;

public class Checkout {


    public static Integer checkout(String skus) {
        final SKU skuB = SKU.skuOf("B", 30).withDiscount(new AmountDiscount(2, 15));

        List<SKU> priceList = ImmutableList.of(skuB,
                SKU.skuOf("A", 50)
                        .withDiscount(new AmountDiscount(3, 20))
                        .withDiscount(new AmountDiscount(5, 50)),
                SKU.skuOf("C", 20),
                SKU.skuOf("D", 15),
                SKU.skuOf("E", 40).withDiscount(new ProductDiscount(2, skuB)));

        Basket basket = new Basket(skus, new Pricing(priceList));
        try {
            return basket.totalCost() - basket.calculateTotalDiscount();
        } catch (Exception e) {
            return -1;
        }
    }

}
