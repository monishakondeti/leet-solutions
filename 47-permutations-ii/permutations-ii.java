class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);//now all duplicates will be together , so that we can skip the duplicate elements when we add to || recurse to the case
        return permutation(new ArrayList<>() , nums,0);
    }
    List<List<Integer>> permutation(List<Integer> p,int[] nums,int index){
        List<List<Integer>> outer = new ArrayList<>();
        if(index == nums.length){
            //means we reached till last index so no elemnts are there to ignore or to take
            outer.add(new ArrayList<>(p));
            return outer;
        }
        int current = nums[index];
        for(int i = 0;i<=p.size();i++){
            List<Integer> temp = new ArrayList<>(p);//temp list already contains processed list , we only take the element in unprocesses(nums) using index and instert it in processed using i
            temp.add(i,current);
            outer.addAll(permutation(temp,nums,index+1));
            if(i<p.size() && current == p.get(i)){
                // to avoid duplicate lists we first look at the neighbour if the neighbour has the same value as current,then inserting after it cannot create anything new.
                break;
            }
        }
        return outer;
    }
}