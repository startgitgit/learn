package function;

import java.util.function.Function;

/**
 * @Author: zhouyq
 * @Date: 2019/8/15 22:22
 * @Version 1.0
 * @Description
 */
public class Program {
    public static void main(String[] args) {
        Function<Integer,String> function = (x) -> {
            System.out.println(x);
            return x.toString();
        };

        Integer result = function.andThen(x -> {
            System.out.println(x + "hello");
            return 20;
        }).apply(10);
    }
}
