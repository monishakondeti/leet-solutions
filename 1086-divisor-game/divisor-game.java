class Solution {
    public boolean divisorGame(int n) {
        Boolean[] dp = new Boolean[n + 1];

        return helper(n, dp);
    }

    boolean helper(int n, Boolean[] dp) {

        if (n == 1) {
            return false;
        }

        if (dp[n] != null) {
            return dp[n];
        }

        for (int i = 1; i < n; i++) {

            if (n % i == 0) {

                if (!helper(n - i, dp)) {
                    dp[n] = true;
                    return true;
                }
            }
        }

        dp[n] = false;
        return false;
    }
}