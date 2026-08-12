class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome
            int left = i;
            int right = i;
            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > longest.length()) {
                    longest = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
            // Even length palindrome
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > longest.length()) {
                    longest = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        return longest;
    }
}