package alg;

import java.util.Stack;

public class IsPail {
    /**
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode index = head;
        while (index != null) {
            stack.push(index);
            index = index.next;
        }
        index = head;
        while (index != null) {
            if (index.val != stack.pop().val) {
                return false;
            }
            index = index.next;
        }
        return true;
    }
}
