package guava;

import com.google.common.base.*;
import com.google.common.cache.*;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

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

        System.out.println(Strings.emptyToNull(" ") == null);

        Multimap<Integer, String> keyValues = ArrayListMultimap.create();
        keyValues.put(1, "a");
        keyValues.put(1, "b");
        keyValues.put(2, "c");
        System.out.println(keyValues.toString());
        System.out.println(keyValues.get(1));

        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                //设置大小，条目数
                .maximumSize(20)
                //设置失效时间，创建时间
                .expireAfterWrite(3, TimeUnit.SECONDS)
                //设置时效时间，最后一次被访问
                //.expireAfterAccess(10, TimeUnit.SECONDS)
                //移除缓存的监听器
                .removalListener(new RemovalListener<String, String>() {
                    @Override
                    public void onRemoval(RemovalNotification<String, String> notification) {
                        System.out.println("有缓存数据被移除了");
                    }
                })
                // 缓存构建的回调
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        return key + "-" + "world";
                    }
                });

        try {
            System.out.println(cache.get("hello"));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1000);
            System.out.println(cache.getIfPresent("hello"));
            System.out.println(cache.get("hello"));
        } catch (Exception e) {
            e.printStackTrace();
        }


        boolean result = Predicates.isNull().apply(1);
        System.out.println(result);
        List<Class<?>> classes = Arrays.asList(
                Object.class, String.class, Number.class, Long.class);
        Iterable<Class<?>> filter = Iterables.filter(classes, Predicates.subtypeOf(Number.class));
        filter.forEach(x -> System.out.println(x.getName()));

        // 元组使用
        Pair<String, Integer> zhouyanqing = Pair.of("zhouyanqing", 18);
        System.out.println(zhouyanqing);
        System.out.println(zhouyanqing.getKey());
        System.out.println(zhouyanqing.getValue());
        System.out.println(zhouyanqing.getLeft());
        System.out.println(zhouyanqing.getRight());


    }
}
