package LeetCode.Common.Easy;

/**
 * LeetCode
 * Problem : https://leetcode.com/problems/merge-two-sorted-lists
 **/
public class MergeTwoSortedLists {

//     Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null, now = null;

        while (l1 != null && l2 != null) {
            ListNode generated = null;

            if (l1.val < l2.val) {
                generated = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                generated = new ListNode(l2.val);
                l2 = l2.next;
            }

            if (head == null) {
                head = now = generated;
                continue;
            }

            now.next = generated;
            now = now.next;
        }

        while (l1 != null) {
            now.next = new ListNode(l1.val);
            now = now.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            now.next = new ListNode(l2.val);
            now = now.next;
            l2 = l2.next;
        }

        return head;
    }
}
