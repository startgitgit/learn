package lombok;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    @Test
    public void main() {
        String[] args = {};
        LombokTest.main(args);
        Assert.assertEquals("a","a");
    }
}
