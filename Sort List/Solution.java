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
    public ListNode sortList(ListNode head) {
        // Base Case: If the length of the linked list is less than or equal to 1, then the list is already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Split the linked list into two halves using "slow and fast pointer" technique to find the midpoint of the linked list
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // The midpoint of the linked list is slow.next
        ListNode mid = slow.next;
        // Set slow.next to null to separate the left and right halves of the linked list
        slow.next = null;

        // Recursively sort the left and right halves of the linked list
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        // Merge the two sorted halves of the linked list
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        // Append the remaining nodes of the left or right half to the end of the sorted list
        curr.next = (left != null) ? left : right;

        return dummy.next;
    }
}
