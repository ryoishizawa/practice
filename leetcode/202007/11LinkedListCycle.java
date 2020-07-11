// wrong answer
public class Solution0 {
    public boolean hasCycle(ListNode head) {
        ListNode curr = head;
        List<ListNode> list = new ArrayList<>();
        while (curr != null && curr.next != null) {
            for (ListNode node: list) {
                // Here does not work in leetcode in case input is [1,1,1] and -1, but should this work..?
                if (node == curr) {
                    return true;
                }
            }
            list.add(curr);
            curr = head.next;
        }
        return false;
    }
}

// Accepted! (but this is slow)
public class Solution1 {
    public boolean hasCycle(ListNode head) {
        ListNode curr = head;
        List<ListNode> list = new ArrayList<>();
        while (curr != null && curr.next != null) {
            for (ListNode node: list) {
                if (node == curr) {
                    return true;
                }
            }
            list.add(curr);
            curr = curr.next; // Here's different from the above solution
        }
        return false;
    }
}

// In above solution, we can use set instead of list. 
// Time complexity can be reduced from O(n^2) to O(n).
public class Solution2 {
    public boolean hasCycle(ListNode head) {
        ListNode curr = head;
        Set<ListNode> set = new HashSet<>();
        while (curr != null && curr.next != null) {
            if (set.contains(curr)) {
                return true;
            }
            set.add(curr);
            curr = curr.next;
        }
        return false;
    }
}

