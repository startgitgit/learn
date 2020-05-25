package singleton;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/5/25 20:00
 */
public class SingleTonLazy2 {
    private static volatile SingleTonLazy2 singleTon;

    public static SingleTonLazy2 getInstance() {
        if (singleTon == null) {
            synchronized (SingleTonLazy2.class) {
                if (singleTon == null) {
                    singleTon = new SingleTonLazy2();
                }
            }
        }
        return singleTon;
    }
}
