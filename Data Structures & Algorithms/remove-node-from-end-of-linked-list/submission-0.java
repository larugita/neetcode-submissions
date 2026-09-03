class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }

        // Reverse the list
        ListNode reversed = reverseList(head);

        // Find the nth node
        int index = 1;
        ListNode remove = reversed;
        ListNode previous = null;

        while (index != n) {
            previous = remove;
            remove = remove.next;
            index++;
        }

        // Remove the node
        if (previous == null) {
            // Removing the first node
            reversed = remove.next;
        } else {
            previous.next = remove.next;
        }

        // Reverse the list back
        return reverseList(reversed);
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}