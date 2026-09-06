class Solution {
    public int firstStableIndex(int[] nums, int k) {

        int n = nums.length;
        //score should be diff of prefix max and suffix min

        //suffixMin stores the min element from i to end
        int[] suffixMin = new int[n];
        //last index of suffix min will be nums last index only 
        suffixMin[n-1] = nums[n-1];
        for(int i = n-2;i>=0;i--){
            suffixMin[i] = Math.min(nums[i],suffixMin[i+1]);
        }
        int prefixMax = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            prefixMax = Math.max(prefixMax,nums[i]);
            //we need to calculate score every time we found 
            int score = prefixMax - suffixMin[i];
            if(score<=k){
                return i;
            }
        }
        return -1;
    }
}
