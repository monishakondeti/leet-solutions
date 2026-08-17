class Solution {
    List<List<Integer>> outer = new ArrayList<>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            backtrack(candidates,0,target,new ArrayList<>());
            return outer;
    }
    void backtrack(int[] nums ,int index,int remainingTarget,List<Integer> inner){
        // at first we take 1st element of candidates and then we keep each candidate and check its sum if it is equal to target we add the inerlist in the outer 
        //base cases....
        if(remainingTarget == 0){
            outer.add(new ArrayList<>(inner));
            return;
        }
        if(remainingTarget < 0 ){
            //we wont add any elemnt in the inner list
            return;
        }
        //we keep on adding the candidate elemnts to the inner list
        for(int i = index;i<nums.length;i++){
            inner.add(nums[i]);
            //we add the elemnt in inner and check the sum
            if(remainingTarget > 0){
                //we add the current element and again need to check from 1st
                backtrack(nums,i,remainingTarget - nums[i],inner);
                //now the exploration is completed and we need to remove the current elemnt to backtrack
            }
            inner.remove(inner.size()-1);
        }
    }
}