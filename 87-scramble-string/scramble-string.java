import java.util.*;

class Solution {
    Map<String, Boolean> dp = new HashMap<>();

    public boolean isScramble(String s1, String s2) {

        if (s1.equals(s2)) {
            return true;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        String key = s1 + "#" + s2;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int n = s1.length();

        for (int i = 1; i < n; i++) {

            // Without swapping
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i))) {

                dp.put(key, true);
                return true;
            }

            // With swapping
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                isScramble(s1.substring(i), s2.substring(0, n - i))) {

                dp.put(key, true);
                return true;
            }
        }

        dp.put(key, false);
        return false;
    }
}