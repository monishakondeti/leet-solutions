class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int row=0;row<dp.length;row++){
            for(int col = 0;col<dp[0].length;col++){
                dp[row][col] = -1;
            }
        }
        return dis(word1,word2,dp,0,0);
    }
    int dis(String word1,String word2,int[][] dp,int i,int j){
        //i points to word1 and j points to word2
        //if i and j has same char then i+1 and j+1 till we reach the end
        if(i==word1.length()){//we also need to process the last char so we do only word1.length()
            //word1 is completed but something may or maynot left in word2
            return word2.length()-j;
        }
        if(j==word2.length()){
            return word1.length()-i;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        //we can do 3 operations we can do here insert,delete,replace
        if(word1.charAt(i) == word2.charAt(j)){
            return dis(word1,word2,dp,i+1,j+1);
        }
        int insert = 1+dis(word1,word2,dp,i,j+1);
        int delete = 1+dis(word1,word2,dp,i+1,j);
        int replace = 1+dis(word1,word2,dp,i+1,j+1);
        dp[i][j] = Math.min(insert,Math.min(delete,replace));
        return dp[i][j];
    }
}