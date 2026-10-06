class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Boolean[] dp = new Boolean[s.length() + 1];

        return match(wordDict, s, 0,dp);
    }
    /*
    boolean match(List<String> wordDict, StringBuilder up, StringBuilder p) {

        // Nothing left to process
        
        if (up.isEmpty()) {
            return true;
        }

        for (String word : wordDict) {

            // Check whether the word is at the beginning of up
            if (up.toString().startsWith(word)) {

                // Choose
                p.append(word);
                up.delete(0, word.length());

                // Explore
                boolean result = match(wordDict, p, up);

                if (result) {
                    return true;
                }

                // Backtrack
                p.delete(p.length() - word.length(), p.length());
                up.insert(0, word);
            }
        }

        // No possible word could complete the string
        return false;
        
    }*/
    boolean match(List<String> wordDict, String s, int index,Boolean[] dp){
        //i beginning of the unprocessed

        if (index == s.length()) {
            return true;
        }

        if(dp[index] != null){
            return dp[index];
        }

        for (String word : wordDict) {

            if (s.startsWith(word,index)) {
                boolean result = match(wordDict, s, index + word.length(),dp);
                if (result) {
                    dp[index] = true;
                    return true;
                }
            }
        }

        // No possible word could complete the string
        dp[index]=false;
        return false;
        
    }
}