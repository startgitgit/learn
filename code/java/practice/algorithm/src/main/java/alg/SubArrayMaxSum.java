package alg;

public class SubArrayMaxSum {
    public int getSubArrayMaxSum(int[] arr) {
        //使用动态规划法
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int max = dp[0];
        for (int i = 1; i < arr.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + arr[i];
            } else {
                dp[i] = arr[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
