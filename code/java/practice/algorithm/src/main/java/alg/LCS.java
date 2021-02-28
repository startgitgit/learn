package alg;

public class LCS {
    public String lcs(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
            return "-1";
        }
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int max = 0, x = 0;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        x = i;
                    }
                }
            }
        }
        return max == 0 ? "-1" : str1.substring(max - x, x);
    }

    public String lcs1(String str1, String str2) {
        int maxlength = 0, index = 0;
        for (int i = 0; i < str2.length(); i++) {
            for (int j = i + 1; j <= str2.length(); j++) {
                if (str1.contains(str2.substring(i, j))) {
                    if ((j - i) > maxlength) {
                        maxlength = j - i;
                        index = i;
                    }
                } else {
                    break;
                }
            }
        }
        if (maxlength == 0) {
            return "-1";
        }
        return str2.substring(index, index + maxlength);
    }

}
