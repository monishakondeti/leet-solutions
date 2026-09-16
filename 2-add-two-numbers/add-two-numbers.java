/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curr = head;
        int val1;
        int val2;
        int carry = 0;
        //the 1st node we are creating is the sum of l1,l2 and carry at beg
        while(l1 != null || l2!= null || carry!=0){
            if(l1!=null){
                //take that node value or else take it as 0
                val1 = l1.val;
            }else{
                val1=0;
            }
            if(l2!=null){
                val2 = l2.val;
            }else{
                val2=0;
            }
            int sum = val1+val2+carry;//if we got sum as more than 1 digit then we need to put the ones place digit in the ans list and rest as the carry
            int digit = sum%10;
            carry = sum/10;
            //we we need to keep the digit in the list we create
            // Get carry for next position
            carry = sum / 10;
            // Create and attach new node
            curr.next = new ListNode(digit);
            // Move curr
            curr = curr.next;
            // Move l1
            if (l1 != null) {
                l1 = l1.next;
            }
            // Move l2
            if (l2 != null) {
                l2 = l2.next;
            }
        }
           // Skip dummy node
            return head.next;
    }
}