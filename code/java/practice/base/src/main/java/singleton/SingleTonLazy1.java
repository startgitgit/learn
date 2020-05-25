package singleton;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/5/25 20:00
 */
public class SingleTonLazy1 {
    private static SingleTonLazy1 singleTon;

    public static synchronized SingleTonLazy1 getInstance() {
        if (singleTon == null) {
            singleTon = new SingleTonLazy1();
        }
        return singleTon;
    }
}
