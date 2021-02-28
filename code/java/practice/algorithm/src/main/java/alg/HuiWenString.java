package alg;

public class HuiWenString {
    public boolean isHuiwen(String s){
        if(s == null || s.length() ==1){
            return true;
        }
        int left =0,right = s.length() -1;
        while (left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
