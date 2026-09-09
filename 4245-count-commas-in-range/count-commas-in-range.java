class Solution {
    public int countCommas(int n) {
        int count = 0;
        for (int num = 1000; num <= n; num++) {    
            count++;
        }
        return count;
    }
}