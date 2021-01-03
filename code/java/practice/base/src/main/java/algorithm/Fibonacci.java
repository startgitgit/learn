package algorithm;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2021/1/3 13:36
 */
public class Fibonacci {
    private static long[] data;

    //    公式：f(n) = f(n-1) + f(n-2)，终止条件：n<=2  f(n) =1
    public static long fab(int n) { // 分析一段代码好坏，有两个指标，时间复杂度和空间复杂度 都是：O(2^n)
        if (n <= 2)
            return 1; // 递归的终止条件
        return fab(n - 1) + fab(n - 2); // 继续递归的过程
    }

    public static long nofab(int n) {
        if (n <= 2) {
            return 1;
        }
        long a = 1;
        long b = 1;
        long c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }


    public static long fab2(int n) {
        if (n <= 2) {
            return 1;
        }

        if (data[n] > 0) {
            return data[n];
        }
        long result = fab2(n - 1) + fab2(n - 2);
        data[n] = result;
        return result;
    }

    public static void main(String[] args) {

        for (int i = 0; i <= 100; i++) {
//            System.out.println(i+":"+fab(i));
//            System.out.println(i + ":" + nofab(i));
            data = new long[i + 1];
            System.out.println(i + ":" + fab2(i));
        }
    }
}
