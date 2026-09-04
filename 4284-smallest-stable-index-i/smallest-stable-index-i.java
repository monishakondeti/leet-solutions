class Solution {
    public int firstStableIndex(int[] nums, int k) {

        int n = nums.length;

        // suffixMin[i] = minimum element from index i to the end
        int[] suffixMin = new int[n];

        // Last element is the minimum for the last index
        suffixMin[n - 1] = nums[n - 1];

        // Build the suffix minimum array from right to left
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        // This stores the maximum element from index 0 to i
        int prefixMax = Integer.MIN_VALUE;

        // Check every index from left to right
        for (int i = 0; i < n; i++) {

            // Update maximum from nums[0] to nums[i]
            prefixMax = Math.max(prefixMax, nums[i]);

            // Calculate instability score
            int score = prefixMax - suffixMin[i];

            // If score <= k, this is the smallest stable index
            if (score <= k) {
                return i;
            }
        }

        // No stable index exists
        return -1;
    }
}