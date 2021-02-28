package alg;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= arr.length; i++) {
            if (map.containsKey(target - arr[i - 1])) {
                return new int[]{map.get(target - arr[i - 1]), i};
            }
            map.put(arr[i - 1], i);
        }
        return new int[]{-1, -1};
    }
}
