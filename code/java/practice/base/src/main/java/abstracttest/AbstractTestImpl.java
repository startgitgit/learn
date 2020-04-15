package abstracttest;

public class AbstractTestImpl extends AbstractTest {
    @Override
    void process() {
        this.parse();
    }

    public static void main(String[] args) {
        AbstractTest abstractTest = new AbstractTestImpl();
        abstractTest.process();
    }
}
