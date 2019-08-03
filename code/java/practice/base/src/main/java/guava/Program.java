package guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

/**
 * @Author: zhouyq
 * @Date: 2019/8/3 23:02
 * @Version 1.0
 * @Description
 */
public class Program {
    public static void main(String[] args) {
        Joiner joiner = Joiner.on("-").skipNulls();
        String s = joiner.join("a", "b", null, "c");
        System.out.println(s);

        Splitter splitter = Splitter.on("-").trimResults().omitEmptyStrings();
        Iterable<String> split = splitter.split(" a -    b - c");
        split.forEach(System.out::println);


        String s1 = CharMatcher.is('a').removeFrom("dfsfsfa");
        String s2 = CharMatcher.is('a').retainFrom("dfsfsfa");
        System.out.println(s1);
        System.out.println(s2);

        int i = CharMatcher.anyOf("ab").indexIn("123ab");
        System.out.println(i);

    }
}
