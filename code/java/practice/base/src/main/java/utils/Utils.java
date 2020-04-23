package utils;

import com.google.common.base.Charsets;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
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
        System.out.println(StringUtils.repeat("=",50));
        System.out.println(StringUtils.center(" Customised Header ", 50, "%"));
        System.out.println(StringUtils.center(" Customised Header ", 50, "="));
        System.out.println(StringUtils.defaultString(null, "defaultValue"));
        System.out.println(StringUtils.abbreviate("aaaaaaaaaaa",5));

        // IOUtils
        InputStream inputStream = IOUtils.toInputStream("aa", Charsets.UTF_8);



    }
}
