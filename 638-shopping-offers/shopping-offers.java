import java.util.*;

class Solution {
    Map<List<Integer>, Integer> dp = new HashMap<>();

    public int shoppingOffers(List<Integer> price,
                              List<List<Integer>> special,
                              List<Integer> needs) {

        return helper(price, special, needs);
    }

    int helper(List<Integer> price, List<List<Integer>> special,
               List<Integer> needs) {

        if (dp.containsKey(needs)) {
            return dp.get(needs);
        }

        int min = 0;

        // Buy items individually
        for (int i = 0; i < needs.size(); i++) {
            min += needs.get(i) * price.get(i);
        }

        // Try every special offer
        for (List<Integer> offer : special) {

            List<Integer> remaining = new ArrayList<>();
            boolean valid = true;

            for (int i = 0; i < needs.size(); i++) {

                if (offer.get(i) > needs.get(i)) {
                    valid = false;
                    break;
                }

                remaining.add(needs.get(i) - offer.get(i));
            }

            if (valid) {
                min = Math.min(min,
                    offer.get(needs.size()) +
                    helper(price, special, remaining));
            }
        }

        dp.put(new ArrayList<>(needs), min);

        return min;
    }
}