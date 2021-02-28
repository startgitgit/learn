package alg;

public class ReverseList {
    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }
        return  pre;
    }
}

