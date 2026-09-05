class Solution {
    public int strStr(String haystack, String needle) {

        // Try every possible starting position in haystack
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {

            // Start from the beginning of needle
            int j = 0;

            // Compare needle with haystack starting from i
            while (j < needle.length() &&
                   haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            // If we matched the complete needle
            if (j == needle.length()) {
                return i;
            }
        }

        // Needle was not found anywhere
        return -1;
    }
}