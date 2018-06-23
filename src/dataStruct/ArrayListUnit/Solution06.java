package dataStruct.ArrayListUnit;

public class Solution06 {
    public static ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        ListNode ln = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = ln;


        ListNode ls = Solution06.swapPairs(l1);
        //循环遍历
        while (ls !=null){
            System.out.print(ls.val+" ");
            ls = ls.next;
        }

    }
}
