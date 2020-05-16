package stringtest;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/5/16 21:51
 */
public class Program {
    public static void main(String[] args) {
        String str = "abcda\\ab";
        System.out.println(str.length());
        System.out.println(str.charAt(str.length()-1));
        System.out.println(str.substring(0));
        System.out.println(str.substring(0,str.length()-1));
        char c = 'a';
        System.out.println(str.indexOf(c));
        System.out.println(str.replace('a','x'));
        System.out.println(str.replaceFirst("a$","7"));
        System.out.println(str.replaceAll("\\\\$","\\\\\\\\"));
    }
}
