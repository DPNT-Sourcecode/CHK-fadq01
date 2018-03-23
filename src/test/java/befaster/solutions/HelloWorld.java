package befaster.solutions;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HelloWorld {

    @Test
    public void sayHelloToTheWorld() {
        assertThat(Hello.hello(null), equalTo("Hello, World!"));
    }
}
