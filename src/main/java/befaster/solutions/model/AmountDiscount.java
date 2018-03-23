package befaster.solutions.model;

public class AmountDiscount {
    private final int amount;
    private final int discount;

    public AmountDiscount(int amount, int discount) {
        this.amount = amount;
        this.discount = discount;
    }

    public int calculate(int forAmount) {
        return (forAmount / amount) * discount;
    }
}
