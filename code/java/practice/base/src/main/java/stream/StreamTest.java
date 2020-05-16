package stream;

import model.Student;

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
public class StreamTest {
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

        Optional<Integer> sum = java.util.stream.Stream.of(1, 2, 3).reduce((x, y) -> x + y);
        System.out.println(sum.get());

        Optional<Integer> sum1 = java.util.stream.Stream.of(1, 2, 3).reduce(new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer x, Integer y) {
                return x + y;
            }
        });
        System.out.println(sum1.get());


        List<Student> studentList = Arrays.asList(Student.builder().name("zhouyq").no(1).score(10D).build(), Student.builder().name("zhouyq").no(1).score(100D).build(),Student.builder().name("dingding").no(2).score(20D).build());
        Map<String, List<Student>> collect = studentList.stream().collect(Collectors.groupingBy(Student::getName));
        Map<String, Double> collect1 = studentList.stream().collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));
        Map<Boolean, List<Student>> collect2 = studentList.stream().collect(Collectors.partitioningBy(student -> student.getScore() > 20));

    }
}
