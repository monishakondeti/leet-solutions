class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-1;i++){
            int current = nums[i];
            int next = nums[i+1];
            int num = current +1; //this we may or not add in the list
            while(num < next){
                list.add(num);
                num++;
            }
        }
        return list;
    }
}