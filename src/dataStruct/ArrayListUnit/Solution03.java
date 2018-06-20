package dataStruct.ArrayListUnit;

/**
 *  Time complexity : O(n)O(n). There are total nn nodes and we visit each node once.
    Space complexity : O(1)O(1). All we need is the four pointers.
 */
public class Solution03 {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(8);
        ListNode l5 = new ListNode(10);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode ln = Solution03.oddEvenList(l1);
        while (ln !=null){
            System.out.print(ln.val+" ");
            ln = ln.next;
        }
    }
}
