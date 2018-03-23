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
        assertThat(Checkout.checkout("AA"), equalTo(100));
    }

    @Test
    public void itemsWithDifferentSKUsReturnCorrectPrice() {
        assertThat(Checkout.checkout("ABCD"), equalTo(115));
    }

    @Test
    public void discountPricingApplied() {
        assertThat(Checkout.checkout("AAA"), equalTo(130));
    }

    @Test
    public void discountItemsHaveAnotherDiscountAsWell() {
        assertThat(Checkout.checkout("AAAAAA"), equalTo(250));
    }

    @Test
    public void discountPricingAppliedForOtherItems() {
        assertThat(Checkout.checkout("BBBBAAAC"), equalTo(240));
    }

    @Test
    public void oneItemFreeDiscount() {
        assertThat(Checkout.checkout("EEB"), equalTo(80));
    }

    @Test
    public void oneItemFreeAlsoTwoForOne() {
        assertThat(Checkout.checkout("EEBB"), equalTo(95));
    }

    @Test
    public void itemNotFound(){
        assertThat(Checkout.checkout("AxA"), equalTo(-1));
    }
}
