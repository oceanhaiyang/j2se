package dataStruct.ArrayListUnit;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution05 {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                return Integer.compare(o1.val, o2.val);
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
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
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(4);
        ListNode lns = new ListNode(6);
        l5.next = l6;
        l6.next = lns;


        ListNode [] listNodes ={l1,l3,l5};
        ListNode ls = Solution05.mergeKLists(listNodes);
        //循环遍历
        while (ls !=null){
            System.out.print(ls.val+" ");
            ls = ls.next;
        }

    }
}
