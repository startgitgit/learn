package mock.jmockit;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import org.junit.Test;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/5/31 17:46
 */
public class AppTest {
    @Mocked
    App app;

    @Test
    public void testSay() {

        //录制
        new Expectations() {{
            app.say(anyString);
            result = "Hello Jackaa";
        }};

        //回放
        System.out.println(app.say("Jack"));

        //验证
        new Verifications() {{
            app.say(anyString);
            times = 1;
        }};
    }
}