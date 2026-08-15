class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        for(int i = 0;i<nums.length;i++){
            xor = xor ^ nums[i];
        }
        if(xor != 0){
            return nums.length;
        }
        //if xor == 0 we have 2 cases, either all elemnts in nums may or may not be 0 
        int countZero = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0){
                countZero++;
            }
        }
        if(countZero == nums.length){
            return 0;
        }
        return nums.length-1;
    }
}