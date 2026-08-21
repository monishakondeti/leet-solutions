class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0,new ArrayList<>());
        return ans;
    }
    void backtrack(int[] nums,int start,List<Integer> subset){
        if(start == nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }
        //we will get 2 posibilites either we add the next elemnt or not
        //takes the element
        subset.add(nums[start]);
        backtrack(nums,start+1,subset);//when we reach the answer we do return and comes back to where it is called,means after return we again come back here and then we remove element 

        //dont take the element, means we need to remove the current element
        subset.remove(subset.size()-1);//we always need to remove the last element to backtrack
        backtrack(nums,start+1,subset);
    }
}