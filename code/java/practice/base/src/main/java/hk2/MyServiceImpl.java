package hk2;

import org.jvnet.hk2.annotations.Service;

import javax.inject.Singleton;

@Service
@Singleton
public class MyServiceImpl implements MyService {

    @Override
    public void helloHK2() {
        System.out.println("my helloHK2 hk2");
    }
}
