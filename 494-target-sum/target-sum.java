class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0, 0);
    }
    int helper(int[] nums, int target, int index, int sum) {
        // Base case
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        // Choose +
        int add = helper(nums, target, index + 1, sum + nums[index]);
        // Choose -
        int subtract = helper(nums, target, index + 1, sum - nums[index]);
        // Total number of ways
        return add + subtract;
    }
}