class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxEnd = new int[n];
        int[] minEnd = new int[n];
        maxEnd[0] = nums[0];
        minEnd[0] = nums[0];
        int result1;
        int result2;
        for(int i = 1;i<n;i++){
            result1 = nums[i]*maxEnd[i-1];
            result2 = nums[i]*minEnd[i-1];
            int current = nums[i];//uses to start freshly from that array
            int newMax = Math.max(current,Math.max(result1,result2));
            int newMin = Math.min(current,Math.min(result2,result1));
            maxEnd[i] = newMax;
            minEnd[i] = newMin;
        }
        int ans=nums[0];
        for(int i = 0;i<maxEnd.length;i++){
            if(maxEnd[i]>ans){
                ans= maxEnd[i];
            }
        }
        return ans;
    }
}