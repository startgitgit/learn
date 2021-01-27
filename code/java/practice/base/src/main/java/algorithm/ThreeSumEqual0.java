package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2021/1/27 20:16
 */
public class ThreeSumEqual0 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> resultarr = new ArrayList<>();
        //存入哈希表
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }
        Integer t;
        int target = 0;
        for(int i = 0; i < nums.length; ++i){
            target = -nums[i];
            //去重
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i + 1; j < nums.length; ++j){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                if((t = map.get(target - nums[j])) != null){
                    //符合要求的情况,存入
                    if(t > j){
                        resultarr.add(new ArrayList<>
                                (Arrays.asList(nums[i], nums[j], nums[t])));

                    }
                    else{
                        break;
                    }
                }
            }
        }
        return resultarr;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(a);
        System.out.println(lists);
    }
}
