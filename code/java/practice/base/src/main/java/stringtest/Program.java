package stringtest;


import org.apache.directory.api.util.Strings;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/5/16 21:51
 */
public class Program {
    public static void main(String[] args) {
        String str = "a4bc\\";
        System.out.println(str);
        System.out.println(str.length());
        System.out.println(str.charAt(str.length() - 1));
        System.out.println(str.substring(0));
        System.out.println(str.substring(0, str.length() - 1));
        char c = 'a';
        System.out.println("index:" + str.indexOf(c));
        System.out.println(str.replace('a', 'x'));
        System.out.println(str.replaceFirst("a$", "7"));
        // replaceAll 的第一个参数是正则表达式，故而要经过两次转义，一次Java、一次正则。因此就需要四个反斜杠才可以匹配一个反斜杠。
        System.out.println(str.replaceAll("\\\\$", "\\\\\\\\"));
        System.out.println(str.replaceAll("\\d", "-"));
    }
}
