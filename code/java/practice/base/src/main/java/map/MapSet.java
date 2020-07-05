package map;

import org.intellij.lang.annotations.Language;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: zhouyq
 * @Date: 2019/1/19 16:48
 * @Version 1.0
 * @Description
 */
public class MapSet {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(16, "16");
        map.put(17, "17");

        HashSet<String> set = new HashSet<>();
        set.add("hello");
        set.add("hello");//重复元素
        set.add("java");
        set.add("world");
        Iterator<String> iterator = set.iterator();
        int index =1;
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            index++;
        }

        ArrayList<String> strings = new ArrayList<>(set);
        for (String string : strings) {
            System.out.println(string);
        }

        ConcurrentHashMap<String,String> ch = new ConcurrentHashMap<>();
        ch.put("a","a");
        ch.put("b","b");
        ch.entrySet().removeIf(x->Objects.equals(x.getValue(),"a"));
        System.out.println(ch.size());

        System.out.println(16 >>> 4);


    }
}
