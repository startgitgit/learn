package singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/5/25 20:00
 */
public class SingleTonLazy3 {
    private  Map<String,String> map = new HashMap<>();
    private SingleTonLazy3() {
        map.put("a","b");
    }

    private static class SingleTonLazy3Holder {
        private static SingleTonLazy3 singleTon = new SingleTonLazy3();

    }

    public static SingleTonLazy3 getInstance() {
        return SingleTonLazy3Holder.singleTon;
    }

}
