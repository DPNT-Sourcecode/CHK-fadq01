package befaster.solutions;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class CheckoutTest {

    @Test
    public void singleItemInShoppingBasketReturnsCorrectPrice(){
        assertThat(Checkout.checkout("A"), equalTo(50));
    }

}