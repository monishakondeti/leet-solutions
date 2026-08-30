class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int offset = 0;
        for(int i = 0;i<nums.length;i++){
            offset+=nums[i];
        }
        int[][] dp = new int[nums.length][2*offset+1];
        for(int row=0;row<dp.length;row++){
            for(int col = 0;col<dp[row].length;col++){
                dp[row][col] =-1;
            }
        }
        return count(nums,0,0,target,dp,offset);
    }
    int count(int[] nums,int index,int currentSum,int target,int[][] dp,int offset){
        //we can either do + or -, if we add then we do currentSum+nums[index], if we sub we do currentSum-nums[index]
        if(index == nums.length){
            if(currentSum == target){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[index][currentSum+offset] != -1){
            return dp[index][currentSum+offset];
        }
        //when we use dp current sum can also be -ve so we use offset here
        //offset means sum of all numbers in nums , it is max psbl absolute sum
        int add = count(nums,index+1,currentSum+nums[index],target,dp,offset);
        int sub = count(nums,index+1,currentSum-nums[index],target,dp,offset);
        dp[index][currentSum+offset] = add+sub;
        return dp[index][currentSum+offset];
    }
}