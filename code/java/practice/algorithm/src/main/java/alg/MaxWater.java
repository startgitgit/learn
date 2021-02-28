package alg;

public class MaxWater {
    public long maxWater(int[] arr) {
        // write code here
        if (arr.length < 1) {
            return 0;
        }
        int i = 0; // 左指针
        int j = arr.length - 1; // 右指针
        int maxLeft = arr[i]; //桶左边的长度
        int maxRight = arr[j]; // 桶右边的长度
        long ret = 0L; // 盛水总量
        while (i < j) {
            // 较低边为左边
            if (maxLeft < maxRight) {
                i++;
                // 当前位置i小于大于较低边，更新较低边的值，小于装水
                if (arr[i] > maxLeft) {
                    maxLeft = arr[i];
                } else {
                    ret += maxLeft - arr[i];
                }
            } else {
                // 较低边为右边
                j--;
                // 当前位置i小于大于较低边，更新较低边的值，小于装水
                if (arr[j] > maxRight) {
                    maxRight = arr[j];
                } else {
                    ret += maxRight - arr[j];
                }
            }
        }
        return ret;
    }
}
