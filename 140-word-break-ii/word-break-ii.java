class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String>[] dp = new ArrayList[s.length()];

        return helper(s, wordDict, 0, dp);
    }

    List<String> helper(String s, List<String> wordDict, int start,
                        List<String>[] dp) {

        if (start == s.length()) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        if (dp[start] != null) {
            return dp[start];
        }

        List<String> result = new ArrayList<>();

        for (int i = start + 1; i <= s.length(); i++) {

            String word = s.substring(start, i);

            if (wordDict.contains(word)) {

                List<String> remaining =
                    helper(s, wordDict, i, dp);

                for (String str : remaining) {

                    if (str.equals("")) {
                        result.add(word);
                    } else {
                        result.add(word + " " + str);
                    }
                }
            }
        }

        dp[start] = result;

        return result;
    }
}