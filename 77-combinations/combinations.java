class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, new ArrayList<>(),n,k);
        return ans;
    }
    void backtrack(int start,List<Integer> currentCombination,int n,int k){
        if(currentCombination.size() == k){//initially currentCombination will be 1
            //we add copy to answer
            ans.add(new ArrayList<>(currentCombination));
            return;
        }
        for(int i =start;i<=n;i++){
            //we choose currentCombination here using i
            currentCombination.add(i);
            backtrack(i+1,currentCombination,n,k);
            //to backtrack we need to undo i,means we only remove last element
            currentCombination.remove(currentCombination.size()-1);
        }
    }
}