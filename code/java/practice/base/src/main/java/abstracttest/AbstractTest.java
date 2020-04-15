package abstracttest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTest.class);

    abstract void process();

    void parse(){
        LOGGER.error("{}","hello world");
    }
}
