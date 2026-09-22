class Solution {
    Boolean[][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        dp = new Boolean[s1.length() + 1][s2.length() + 1];

        return helper(s1, s2, s3, 0, 0);
    }

    boolean helper(String s1, String s2, String s3, int i, int j) {

        if (i == s1.length() && j == s2.length()) {
            return true;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int k = i + j;

        boolean takeS1 = false;
        boolean takeS2 = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            takeS1 = helper(s1, s2, s3, i + 1, j);
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            takeS2 = helper(s1, s2, s3, i, j + 1);
        }

        return dp[i][j] = takeS1 || takeS2;
    }
}