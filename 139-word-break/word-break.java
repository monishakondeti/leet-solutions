class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[][] dp = new boolean[s.length()][2];

        return match(s, wordDict, dp, 0);
    }

    boolean match(String s, List<String> wordDict, boolean[][] dp, int start) {

        // Entire string is matched
        if (start == s.length()) {
            return true;
        }

        // Already calculated
        if (dp[start][0]) {
            return dp[start][1];
        }

        // Try every possible substring
        for (int i = start + 1; i <= s.length(); i++) {

            String word = s.substring(start, i);

            if (wordDict.contains(word)) {

                if (match(s, wordDict, dp, i)) {
                    dp[start][0] = true;
                    dp[start][1] = true;
                    return true;
                }
            }
        }

        dp[start][0] = true;
        dp[start][1] = false;

        return false;
    }
}