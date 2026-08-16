class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        //initially num of jumps will be 0 and we are at 0th index
        //we need to choose the best jump
        int current = 0;
        //we need to store the where we are jumpming index to see if we are actually jumping or not using greedy approach
        int jumpIndex = 0;
        for(int i = 0;i<nums.length-1;i++){
            int maxReach = i+nums[i];//now we need to check whether the reach is good or not
            if(maxReach > current){
                current = maxReach;
                //if we are changing the maxReach before moving to jummpIndex 
            }
            if(i == jumpIndex){
                //we only increment jump if we reach the boundary or else we can make 
                jumps++;
                jumpIndex = current;
            }
        }
        return jumps;
    }
}