package regex;

import java.util.ArrayList;
import java.util.List;

public class program {
    public static void main(String[] args) {
        String a = "eeeeeeeeee\\n";
        System.out.println(a);
        System.out.println(a.replaceAll("\\\\", ""));
        //在regex中"\\"表示一个"\"，在java中一个"\"也要用"\\"表示。这样，前一个"\\"代表regex中的"\"，后一个"\\"代表java中的"\"。所以要想使用replaceAll方法将字符串中的反斜杠("\")替换成空字符串("")，则需要这样写：str.replaceAll("\\\\","");


    }


    public static <T> List<T> getRecords(T c) {

        List<T> list = new ArrayList<T>();
        list.add(c);
        return list;
    }
}
