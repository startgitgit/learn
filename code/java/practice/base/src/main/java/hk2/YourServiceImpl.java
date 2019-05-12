package hk2;

import org.jvnet.hk2.annotations.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * @Author: zhouyq
 * @Date: 2019/5/12 22:04
 * @Version 1.0
 * @Description
 */

@Service
public class YourServiceImpl implements YourService {
    @Inject
    private MyService myService;

    @PostConstruct
    public void test() {
        myService.helloHK2();
    }

    @Override
    public void helloHK2() {
        System.out.println("your helloHK2 hk2");
        myService.helloHK2();
    }
}
