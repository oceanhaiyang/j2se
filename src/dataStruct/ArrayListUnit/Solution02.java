package dataStruct.ArrayListUnit;

public class Solution02 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        //找到被删元素的前一位
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        //删除
        first.next = first.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode ll = new ListNode(3);
        l1.next = l2;
        l2.next = ll;

        ListNode ln = Solution02.removeNthFromEnd(l1,1);
        while (ln !=null){
            System.out.print(ln.val+" ");
            ln = ln.next;
        }
    }

}