class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates,target,0,new ArrayList<>());
        return ans;
    }
    void backtrack(int[] nums,int remainingTarget,int index,List<Integer> inner){
        if(remainingTarget == 0){
            ans.add(new ArrayList<>(inner));
            return;
        }
        if(remainingTarget < 0){
            //means the sum in our list exceed to stop doing it 
            return;
        }
        for(int i = index;i<nums.length;i++){
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            inner.add(nums[i]);
            if(remainingTarget > 0){
                //still we left with target
                backtrack(nums,remainingTarget - nums[i],i+1,inner);//index+1 coz we can use each element only once
                
            }
            inner.remove(inner.size()-1);
        }
        
    }
}