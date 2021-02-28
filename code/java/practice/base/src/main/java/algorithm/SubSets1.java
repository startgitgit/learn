package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2021/1/31 8:16
 */
public class SubSets1 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int pow = (int) Math.pow(2, n);
        int pow1 = (int) Math.pow(2, n + 1);
        for(int i = pow; i< pow1; i++){
            String bitmask=Integer.toBinaryString(i).substring(1);
            List<Integer> cur= new ArrayList<>();
            for (int j =0;j<n;j++){
                if(bitmask.charAt(j) == '1') {
                    cur.add(nums[j]);
                }
            }
            result.add(cur);
        }
        return result;
    }

    public static void main(String[] args) {
        SubSets1 subSets1 = new SubSets1();
        subSets1.subsets(new int[] {1,2,3});
    }
}

