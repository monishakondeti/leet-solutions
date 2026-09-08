class Solution {
    public int countCommas(int n) {
        int count = 0;
        for (int num = 1; num <= n; num++) {
            String str = String.valueOf(num);
            int i = str.length();
            while (i > 3) {
                i -= 3;
                count++;
            }
        }
        return count;
    }
}