// Date: 11 Jul 2020

// Copied from leetcode
// Good explanation in YouTube: https://www.youtube.com/watch?v=MRe3UsRadKw&feature=emb_logo

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
class Solution1 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}

// solved by myself after understanding recursive solution.
class Solution2 {
    public ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        ListNode nextNode = null;
        while (head != null && head.next != null) {
            nextNode = head.next;
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
        }
        if (head != null) {
            head.next = prevNode;
        }
        return head;
    }
}

