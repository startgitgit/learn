package alg;

public class ReverString {
    public String revertString(String s) {
        if (s == null) {
            return s;
        }
        char[] chars = s.toCharArray();
        for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
        }
        return new String(chars);
    }
}
