package dataStruct.ArrayListUnit;

class Solution07 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(6);
        ListNode ln = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = ln;


        ListNode ls = Solution07.reverseKGroup(l1,3);
        //循环遍历
        while (ls !=null){
            System.out.print(ls.val+" ");
            ls = ls.next;
        }

    }
}
