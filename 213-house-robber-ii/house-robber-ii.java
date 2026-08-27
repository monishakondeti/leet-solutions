class Solution {
    public int rob(int[] nums) {
        //we have 2 cases here,either rob the 1st house or skip the 1st house 
        
        if(nums.length == 1){
           return nums[0];
        }

        int robFirstHouse = robHouse(nums,0,nums.length-2);
        int skipFirstHouse = robHouse(nums,1,nums.length-1);
        return Math.max(robFirstHouse,skipFirstHouse);
    }
    int robHouse(int[] nums,int start,int end){

        if(start == end){
            return nums[start];
        }

        int[] dp = new int[nums.length]; //arr gives the max of rob or skip
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start],nums[start+1]); // this cheks which is larger 
        for(int i = start+2;i<=end;i++){
            int rob = nums[i] + dp[i-2];
            int skip = dp[i-1];
            dp[i] = Math.max(rob,skip);
        }
        return dp[end];
    }
}