package utils;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static void main(String[] args) {
        //CollectionUtils
        List<String> list = new ArrayList<>();
        System.out.println(CollectionUtils.isEmpty(list));

        // ArrayUtils
        String[] as = {"a","b"};
        String[] cs = ArrayUtils.add(as, "c");
        System.out.println( ArrayUtils.contains(as,"a"));

        // StringUtils
        System.out.println(StringUtils.equalsIgnoreCase("aa","aa"));


    }
}
