class Solution {
    public void nextPermutation(int[] nums) {
        
        int n = nums.length - 1;

        // Step 1: Find the pivot
        int i = n;

        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }

        // If i == 0, the whole array is descending
        // So reverse the entire array
        if (i == 0) {
            reverse(nums, 0, n);
            return;
        }

        // Step 2: Find the smallest number greater than pivot
        int j = n;

        while (nums[j] <= nums[i - 1]) {
            j--;
        }

        // Step 3: Swap pivot and that number
        int temp = nums[i - 1];
        nums[i - 1] = nums[j];
        nums[j] = temp;

        // Step 4: Reverse the suffix
        reverse(nums, i, n);
    }

    // Reverse array from left to right
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}