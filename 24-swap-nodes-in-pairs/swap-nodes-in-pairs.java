class Solution {
    public ListNode swapPairs(ListNode head) {

        // If there are less than 2 nodes, nothing to swap
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = first.next;
        ListNode nextNode = second.next;

        // New head will be the second node
        ListNode newHead = second;

        // Previous node of the current pair
        ListNode prev = null;

        while (first != null && first.next != null) {

            // Connect previous part to second
            if (prev != null) {
                prev.next = second;
            }
            // Swap first and second
            first.next = nextNode;
            second.next = first;
            // Move prev to the end of the swapped pair
            prev = first;
            // Move to the next pair
            first = first.next;
            if (first == null || first.next == null) {
                break;
            }
            second = first.next;
            nextNode = second.next;
        }
        return newHead;
    }
}