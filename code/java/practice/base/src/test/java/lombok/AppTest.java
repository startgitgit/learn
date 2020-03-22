package lombok;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

public class AppTest {

    @Test
    public void main() {
        String[] args = {};
        LombokTest.main(args);
        Assert.assertEquals("a","a");
        Assert.assertTrue(Objects.equals("a","a"));
    }

    @Test
    public void test() {
        Assert.assertTrue(true);
    }
}
