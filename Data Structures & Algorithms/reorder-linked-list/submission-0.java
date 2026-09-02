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
    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        //Split lists
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode half2 = slow.next;
        slow.next = null;

        //Reverse half2
        ListNode prev = null;
        ListNode curr = half2;
        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        ListNode first = head;
        ListNode second = prev;

        while(second != null){
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            first.next = second;
            second.next = firstNext;
            //But now you lose the entire rest ofthe second list,
            // but on the next loop you want first.next = the original secondNext.
            //OK good, you stored it in secondNext.
            //Now, im stuck on the tricky part for me again, which is reassigning the values.

            first = firstNext;
            second = secondNext;
            
        }
        
    }
}
