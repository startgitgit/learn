package hk2;


import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.ServiceLocatorFactory;

/**
 * @Author: zhouyq
 * @Date: 2019/5/12 8:45
 * @Version 1.0
 * @Description
 */
public class Program {

    public static void main(String[] args) {
        ServiceLocator locator = ServiceLocatorFactory.getInstance().create("CustomResolverTest");
        Populator.populate(locator);
        MyService myService = locator.getService(MyService.class);
        myService.helloHK2();
    }

}

