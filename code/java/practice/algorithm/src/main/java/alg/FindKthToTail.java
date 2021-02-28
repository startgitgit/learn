package alg;

public class FindKthToTail {
    public ListNode findKthToTail(ListNode pHead, int k) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        int i = k;
        for (; i > 0 && fast != null; i--) {
            fast = fast.next;
        }
        if (i > 0) {
            return null;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
