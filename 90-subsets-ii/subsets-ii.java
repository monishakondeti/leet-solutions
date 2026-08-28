class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums,0,new ArrayList<>());
        return ans;
    }
    void backtrack(int[] nums,int index,List<Integer> subset){
        ans.add(new ArrayList<>(subset));
        //we will get 2 posibilites either we add the next elemnt or not
        //takes the element
        for(int i = index;i<nums.length;i++){
            if(i>index && nums[i] == nums[i-1]){
                continue;
            }
            subset.add(nums[i]);
            backtrack(nums,i+1,subset);
            subset.remove(subset.size()-1);
        }
    }
}