class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int num : nums){
            if(num != 0){
                nums[index] = num;
                index++;//to skip the index of actual value coz we already moved it forward
            }
        }
        //now we will have the last indicies left coz we pushed all front
        while(index<nums.length){
            //fill the left over num with 0
            nums[index] = 0;
            index++;
        } 
    }
}