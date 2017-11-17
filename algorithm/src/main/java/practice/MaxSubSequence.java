package practice;

/**
 * @author JesonLee
 * @date 2017/11/2.
 */
public class MaxSubSequence {
    public static int maxSubSequenceLength(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                } else {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[s1.length() - 1][s2.length() - 1];
    }

    public static int maxSubStringLength(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        int max = 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    max = dp[i][j] > max ? dp[i][j] : max;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }

    private static String maxSubString(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        int max = 0;
        int end = 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        end = i;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return s1.substring(end - max + 1, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(maxSubString("123js89adg23", "sdfadg21"));
    }
}
