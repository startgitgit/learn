package alg;

import java.util.ArrayList;

public class SortList {
    public ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        list.sort((num1, num2) -> {
            return (num1 - num2);
        });

        int i = 0;
        temp = head;
        while (head != null) {
            head.val = list.get(0);
            i++;
            head = head.next;
        }
        return temp;
    }
}
