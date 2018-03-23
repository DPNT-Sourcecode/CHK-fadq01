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

}