class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        for(int i =0;i<=n;i++){
            for(int j = 0;j<=target;j++){
                dp[i][j] = -1;
            }
        }
        return helper(n,k,target,dp);
    }
    int helper(int n ,int k,int target,int[][] dp){
        if(n==0 && target==0){
            return 1;
        }
        if(n==0 || target<=0){
            return 0;
        }
        if(target<n || target>n*k){
            return 0;
        }
        if(dp[n][target]!=-1){
            //already exists means we return it instead of calculating again
            return dp[n][target];
        }
        int ways=0;
        for(int i = 1;i<=k;i++){
            ways =(ways+helper(n-1,k,target-i,dp)) % 1000000007;
        }
        return dp[n][target] = ways;
    }
}