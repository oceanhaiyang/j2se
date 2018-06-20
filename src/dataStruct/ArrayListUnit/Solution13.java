package dataStruct.ArrayListUnit;

public class Solution13 {

    public static boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next!=null && runner.next.next!=null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-10);
        ListNode l2 = new ListNode(-3);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        //l4.next = l1;


         System.out.println(Solution13.hasCycle(l1));
    }


}