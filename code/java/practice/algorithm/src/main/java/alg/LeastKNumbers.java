package alg;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LeastKNumbers {
    public List<Integer> getLeastKNumbers(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            return res;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((num1, num2) -> (num2 - num1));
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < queue.peek()) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            res.add(queue.poll());
        }
        return res;
    }
}
