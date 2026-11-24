class Solution {
    public int calculateMinimumHP(int[][] dungeon) {

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(dungeon, dp, 0, 0);
    }

    int helper(int[][] dungeon, int[][] dp, int i, int j) {

        int m = dungeon.length;
        int n = dungeon[0].length;

        if (i == m - 1 && j == n - 1) {
            return Math.max(1, 1 - dungeon[i][j]);
        }

        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = helper(dungeon, dp, i, j + 1);
        int down = helper(dungeon, dp, i + 1, j);

        int minHealth = Math.min(right, down);

        dp[i][j] = Math.max(1, minHealth - dungeon[i][j]);

        return dp[i][j];
    }
}