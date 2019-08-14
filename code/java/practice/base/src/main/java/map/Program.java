package map;

import org.intellij.lang.annotations.Language;

import java.util.*;

/**
 * @Author: zhouyq
 * @Date: 2019/1/19 16:48
 * @Version 1.0
 * @Description
 */
public class Program {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(16, "16");
        map.put(17, "17");

        HashSet<String> h = new HashSet<>();
        h.add("a");
        h.add("b");
        Iterator<String> iterator = h.iterator();
        int index =1;
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            index++;
        }
        ArrayList<String> strings = new ArrayList<>(h);
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }


    }
}
