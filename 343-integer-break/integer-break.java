class Solution {
    public int integerBreak(int n) {
         int[] dp=new int[n+1];
         return maxProduct(n,dp);
    }
    int maxProduct(int n,int[] dp){
        if(n==2){
            return 1;
        }
        if (dp[n] != 0) {
           return dp[n];
        }
        int max = 0;
        for(int i = 1;i<=n/2;i++){
            //n/2 to remove duplicate slips
            int remaining = n-i;
            int product1= i*remaining;
            int product2 = i*maxProduct(remaining,dp);//this is the 2nd product where recursion begins 
            max=Math.max(max,Math.max(product1,product2));
        }
        dp[n]=max;
        return dp[n];
    }
}