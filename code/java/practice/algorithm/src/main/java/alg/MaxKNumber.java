package alg;

import java.util.PriorityQueue;

public class MaxKNumber {
    public int getMaxKnumber(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 0 || k > arr.length) {
            return -1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > queue.peek()) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        return queue.peek();
    }
}
