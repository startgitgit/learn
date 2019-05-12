package hk2;

import org.glassfish.hk2.api.DynamicConfiguration;
import org.glassfish.hk2.api.DynamicConfigurationService;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.BuilderHelper;

import javax.inject.Singleton;

/**
 * @Author: zhouyq
 * @Date: 2019/5/12 20:00
 * @Version 1.0
 * @Description
 */
public class Populator {
    public static void populate(ServiceLocator locator) {
        DynamicConfigurationService dcs = locator.getService(DynamicConfigurationService.class);
        DynamicConfiguration config = dcs.createDynamicConfiguration();

        // The InjectionResolver we are showcasing
        config.bind(BuilderHelper.link(MyServiceImpl.class).
                to(MyService.class).
                in(Singleton.class.getName()).
                build());
        config.bind(BuilderHelper.link(YourServiceImpl.class).
                to(YourService.class).
                in(Singleton.class.getName()).
                build());
        // And commit
        config.commit();
    }

}