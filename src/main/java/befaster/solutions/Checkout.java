package befaster.solutions;

import befaster.solutions.model.Basket;
import befaster.solutions.model.Pricing;

public class Checkout {


    public static Integer checkout(String skus) {
        Basket basket = new Basket(skus, new Pricing());

        return basket.totalCost() - basket.calculateTotalDiscount();
    }

}
