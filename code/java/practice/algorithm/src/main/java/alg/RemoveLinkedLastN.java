package alg;

public class RemoveLinkedLastN {
    public ListNode removeLastN(ListNode head, int n) {
        ListNode temp = new ListNode();
        temp.next = head;
        ListNode fast = head;
        ListNode slow = temp;
        int i = n;
        for (; i > 0 && fast != null; i--) {
            fast = fast.next;
        }
        if (i > 0) {
            return null;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        assert slow.next != null;
        slow.next = slow.next.next;
        return temp.next;
    }
}
