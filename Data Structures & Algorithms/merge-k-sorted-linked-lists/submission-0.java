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
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0) {
            return null;
        }

        ArrayList<ListNode> currentLists = new ArrayList<>();

        for (ListNode list : lists) {
            currentLists.add(list);
        }

        while (currentLists.size() > 1) {

            ArrayList<ListNode> nextRound = new ArrayList<>();

            for (int i = 0; i < currentLists.size(); i += 2) {

                if (i == currentLists.size() - 1) {
                    nextRound.add(currentLists.get(i));
                } else {
                    ListNode merged = mergeTwoLists(
                        currentLists.get(i),
                        currentLists.get(i + 1)
                    );

                    nextRound.add(merged);
                }
            }

            currentLists = nextRound;
        }

        return currentLists.get(0);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2){

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                current.next = list1;
                list1 = list1.next;
            }
            else{
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if(list1 != null){
            //add the remaining of list1
            current.next = list1;
        }
        if(list2 != null){
            //add the remaining of list2
            current.next = list2;
        }
        return dummy.next;
    }
}