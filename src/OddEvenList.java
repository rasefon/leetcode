/**
 * Created by rasefon on 16-7-2.
 */
public class OddEvenList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode po = head, pe = po.next, peHead = pe;

        while (po.next != null && pe.next != null) {
            po.next = pe.next;
            po = pe.next;
            pe.next = po.next;
            pe = po.next;
        }

        po.next = peHead;
        return head;
    }
}
