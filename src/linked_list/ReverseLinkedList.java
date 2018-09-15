package linked_list;

/**

 * Reverse a singly linked list.
 */
public class ReverseLinkedList {
    //定义链表结构
     public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Main method
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //构造1->2->3->4->5的链表
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        //ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        //node5.next = node6;
        //调用方法
        ListNode newNode = new ReverseLinkedList().reverseList(node1);
        while (newNode != null) {
            System.out.println(newNode.val);//打印即可
            newNode=newNode.next;
        }
    }

    public  ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
