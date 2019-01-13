package group;


import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhouyq
 * @Date: 2019/1/13 8:46
 * @Version 1.0
 * @Description 集合按指定大小分组
 */

public class Program {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int length = data.size();
        int size = 5;
        for (int i = 0; i < length; i = i + size) {
            if ((i + size) > length) {
                System.out.println(data.subList(i, length));
            } else {
                System.out.println(data.subList(i, i + size));
            }
        }
    }
}
