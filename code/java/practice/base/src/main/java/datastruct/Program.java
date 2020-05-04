package datastruct;

import java.util.LinkedList;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/5/4 11:54
 */
public class Program {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list.poll());
    }
}
