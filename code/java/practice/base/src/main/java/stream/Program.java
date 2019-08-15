package stream;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: zhouyq
 * @Date: 2019/3/14 22:40
 * @Version 1.0
 * @Description
 */
public class Program {
    public static void main(String[] args) {

        //List转stream
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        long count = integers.stream().filter(x -> x == 4).count();

        List<Integer> result = Optional.ofNullable(integers).
                orElse(Collections.emptyList()).stream().filter(Objects::nonNull).
                map(x -> x * 2).collect(Collectors.toList());
        System.out.println(result);


        //数组转stream
        Arrays.stream(Optional.ofNullable(args).orElse(new String[0])).forEach(System.out::println);

        //reduce

        Optional<Integer> sum = Stream.of(1, 2, 3).reduce((x, y) -> x + y);
        System.out.println(sum.get());

        Optional<Integer> sum1 = Stream.of(1, 2, 3).reduce(new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer x, Integer y) {
                return x + y;
            }
        });
        System.out.println(sum1.get());

    }
}
