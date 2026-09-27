class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];

        Arrays.fill(dp, -1);

        return Math.min(helper(cost, dp, 0),
                        helper(cost, dp, 1));
    }

    int helper(int[] cost, int[] dp, int i) {

        if (i >= cost.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int oneStep = helper(cost, dp, i + 1);
        int twoStep = helper(cost, dp, i + 2);

        dp[i] = cost[i] + Math.min(oneStep, twoStep);

        return dp[i];
    }
}