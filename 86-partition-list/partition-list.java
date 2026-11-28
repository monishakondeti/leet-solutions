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
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(-1);
        ListNode largeHead = new ListNode(-1);
        ListNode curr1 = smallHead;
        ListNode curr2 = largeHead;
        ListNode temp2 = curr2;
        ListNode temp = head;
        while(temp!=null){
            if(temp.val<x){
                //add in small linked list
                ListNode nn = new ListNode(temp.val);
                curr1.next = nn;
                curr1 = nn;
            }else{
                ListNode nn = new ListNode(temp.val);
                curr2.next = nn;
                curr2 = nn;
            }
            temp=temp.next;
        }
        //now join small and large ll
        curr1.next = temp2.next;
        return smallHead.next;
    }
}