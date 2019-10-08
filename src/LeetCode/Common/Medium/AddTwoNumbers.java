package LeetCode.Common.Medium;

/**
 * LeetCode
 * Problem : https://leetcode.com/problems/add-two-numbers
 **/
public class AddTwoNumbers {

//     Definition for singly-linked list.
     public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = null, now = null;
            boolean isFirst = true;
            int carry = 0;

            while (l1 != null && l2 != null) {
                int sum = l1.val + l2.val + carry;
                carry = 0;
                l1 = l1.next;
                l2 = l2.next;

                carry = sum / 10;
                int remain = sum % 10;
                ListNode generated = new ListNode(remain);

                if (isFirst) {
                    head = now = generated;
                    isFirst = false;
                    continue;
                }

                now.next = generated;
                now = now.next;
            }

            while (l1 != null) {
                int sum = l1.val + carry;
                carry = 0;
                l1 = l1.next;

                carry = sum / 10;
                int remain = sum % 10;
                now.next = new ListNode(remain);
                now = now.next;
            }

            while (l2 != null) {
                int sum = l2.val + carry;
                carry = 0;
                l2 = l2.next;

                carry = sum / 10;
                int remain = sum % 10;
                now.next = new ListNode(remain);
                now = now.next;
            }

            if (carry > 0) {
                now.next = new ListNode(carry);
                carry = 0;
                now = now.next;
            }

            return head;
        }
    }
}
