package dataStruct.ArrayListUnit;

public class Solution16{
    public static ListNode insertionSortList(ListNode head) {
        ListNode helper=new ListNode(0);
        ListNode pre=helper;
        ListNode current=head;
        while(current!=null) {
            pre=helper;
            while(pre.next!=null&&pre.next.val<current.val) {
                pre=pre.next;
            }
            ListNode next=current.next;
            current.next=pre.next;
            pre.next=current;
            current=next;
        }
        return helper.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);


        l1.next = l2;
        l2.next = l3;
        l3.next = l4;



        ListNode ls = Solution16.insertionSortList(l1);
        //循环遍历
        while (ls != null) {
            System.out.print(ls.val + " ");
            ls = ls.next;
        }
    }
}