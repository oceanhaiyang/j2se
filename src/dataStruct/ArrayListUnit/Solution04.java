package dataStruct.ArrayListUnit;

class Solution04 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
        ListNode current = fakeHead;

        while (l1 != null || l2 != null) {
            if (l1 == null || (l2 != null && l1.val >= l2.val)) {
                current.next = l2;
                current = l2;
                l2 = l2.next;
            } else {
                current.next = l1;
                current = l1;
                l1 = l1.next;
            }
        }
        return fakeHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode ll = new ListNode(4);
        l1.next = l2;
        l2.next = ll;
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        ListNode ln = new ListNode(4);
        l3.next = l4;
        l4.next = ln;
        ListNode ls = Solution04.mergeTwoLists(l1,l3);
        //循环遍历
        while (ls !=null){
            System.out.print(ls.val+" ");
            ls = ls.next;
        }

    }
}
