package Exception;

import java.util.Objects;

/**
 * @Author: zhouyq
 * @Date: 2019/3/30 15:28
 * @Version 1.0
 * @Description
 */
public class Program {
    public static void main(String[] args) {
        Integer value= null;
        Objects.requireNonNull(value);
        System.out.println(value);
    }



}
