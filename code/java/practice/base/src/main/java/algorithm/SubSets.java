package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2021/1/31 7:53
 */
public class SubSets {
    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(t));
        }
        return ans;
    }

    public static void main(String[] args) {
        SubSets sets = new SubSets();
        sets.subsets(new int[]{1,2,3});
    }

}
