package alg;

public class FindFirstCommonNode {
    public ListNode find(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null || listNode2 == null) {
            return null;
        }
        ListNode p1 = listNode1;
        ListNode p2 = listNode2;
        while (p1 != p2) {
            p1 = p1 == null ? listNode2 : p1.next;
            p2 = p2 == null ? listNode1 : p2.next;
        }
        return p1;
    }
}
