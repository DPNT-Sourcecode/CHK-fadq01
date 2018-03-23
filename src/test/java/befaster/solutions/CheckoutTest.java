package befaster.solutions;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CheckoutTest {

    @Test
    public void singleItemInShoppingBasketReturnsCorrectPrice() {
        assertThat(Checkout.checkout("A"), equalTo(50));
    }

    @Test
    public void moreThanOneItemInShoppingBasketReturnsCorrectPrice() {
        assertThat(Checkout.checkout("A A"), equalTo(100));
    }

    @Test
    public void itemsWithDifferentSKUsReturnCorrectPrice() {
        assertThat(Checkout.checkout("A B C D"), equalTo(115));
    }

    @Test
    public void discountPricingApplied() {
        assertThat(Checkout.checkout("3A"), equalTo(130));
    }

}