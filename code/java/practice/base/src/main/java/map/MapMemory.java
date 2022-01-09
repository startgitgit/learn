package map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapMemory {
    public static void main(String[] args) {
        long start = 0 ;
        long end = 0 ;
// 先垃圾回收
        System.gc();
        start = Runtime.getRuntime().freeMemory();
        Map<Long,Long> map = new ConcurrentHashMap();
        for ( long i = 20000000 ; i < 50000000 ; i ++ ) {
            map.put(i, i);
        }
// 快要计算的时,再清理一次
        System.gc();
        end = Runtime.getRuntime().freeMemory();
        System.out.println( " 一个HashMap对象占内存: " + (end - start));
    }

}
