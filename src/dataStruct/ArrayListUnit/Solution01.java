package dataStruct.ArrayListUnit;

public class Solution01 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;//进位
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;//当前节点的值
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;//最终结果的链表
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode ll = new ListNode(3);
        l1.next = l2;
        l2.next = ll;
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(6);
        ListNode ln = new ListNode(4);
        l3.next = l4;
        l4.next = ln;
        ListNode ls = Solution01.addTwoNumbers(l1, l3);
        //循环遍历
        while (ls !=null){
            System.out.print(ls.val+" ");
            ls = ls.next;
        }

    }
}
