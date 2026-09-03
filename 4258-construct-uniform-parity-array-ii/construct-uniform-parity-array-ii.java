class Solution {
    public boolean uniformArray(int[] nums1) {

        // Step 1: Find the smallest element
        int min = Integer.MAX_VALUE;
        for (int num : nums1) {
            min = Math.min(min, num);
        }

        // Step 2: If the minimum is odd,
        // we can make every number odd
        if (min % 2 == 1) {
            return true;
        }

        // Step 3: Minimum is even.
        // If any odd number exists, it can never become even.
        for (int num : nums1) {
            if (num % 2 == 1) {
                return false;
            }
        }

        // Step 4: All numbers are already even
        return true;
    }
}