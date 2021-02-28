package alg;

import java.util.Stack;

public class LinkedHuiWen {
    public boolean isHuiWen(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.val != stack.pop().val) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }
}
