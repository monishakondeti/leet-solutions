class Solution {
    public int maxProduct(int[] nums) {

        int maxProduct = nums[0];
        int minProduct = nums[0];

        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int current = nums[i];

            int oldMax = maxProduct;
            int oldMin = minProduct;

            maxProduct = Math.max(current,
                    Math.max(current * oldMax, current * oldMin));

            minProduct = Math.min(current,
                    Math.min(current * oldMax, current * oldMin));

            answer = Math.max(answer, maxProduct);
        }

        return answer;
    }
}