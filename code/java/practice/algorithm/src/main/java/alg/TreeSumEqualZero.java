package alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TreeSumEqualZero {
    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        if (arr.length < 3) {
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int target = 0;
        Integer t = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i - 1] == arr[i]) {
                continue;
            }
            target = -arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (j > i + 1 && arr[j - 1] == arr[j]) {
                    continue;
                }
                t = map.get(target - arr[j]);
                if (t != null) {
                    if (t > j) {
                        res.add(new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[t])));
                    } else {
                        break;
                    }
                }
            }
        }
        return res;
    }
}
