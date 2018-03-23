package befaster.solutions;

import befaster.solutions.model.Basket;
import befaster.solutions.model.Pricing;

public class Checkout {


    public static Integer checkout(String skus) {
        Basket basket = new Basket(skus, new Pricing());
        try {
            return basket.totalCost() - basket.calculateTotalDiscount();
        } catch (Exception e) {
            return -1;
        }
    }

}