package thinking_java;

/**
 * Created by lhy on 2018/7/12.
 */
public class ListNodeTest {
    // 2.在单链表中删除倒数第k个节点(方法一)
    public static ListNode removeLastKthNode(ListNode head, int k) {
        if (k <= 0 || head == null)
            return head;
        ListNode p = head;
        for (int i = 0; i < k; i++) {
            if (p.nextNode != null)
                p = p.nextNode;
            else
                return head;
        }//p到第k个
        ListNode q = head;
        while (p.nextNode != null) {
            p = p.nextNode;
            q = q.nextNode;
        }
        q.nextNode = q.nextNode.nextNode;
        return head;
    }

    // 2.在单链表中删除倒数第k个节点(方法二)
    /*public static ListNode removeLastKthNode2(ListNode
                                                      head, int k) {
        if(k <= 0 ||head == null)return head;
        ListNode p = head;
        while(p!=null){
            p = p.nextNode;
            k--;
        }
        if(k==0)return head.nextNode;
        if(k<0){
            ListNode q = head;
            while(++k!=0){ //这里注意，先自加，在判断
                q=q.nextNode;
            }
            q.nextNode=q.nextNode.nextNode;
        }
        return head;
    }*/
    // 创建链表
    public static ListNode creatListNode(int data[]) {
        ListNode head = new ListNode (data[0]);
        ListNode temp = head;
        for (int i = 1; i < data.length; i++) {
            ListNode headNext = new ListNode(data[i]);
            temp.nextNode = headNext;
            temp = temp.nextNode;
        }
        return head;
    }

    // 测试个方法
    public static void main(String[] args) {
        int[] data1 = { 1, 2, 3, 4, 5 };
        ListNode head1 = creatListNode(data1);
        //在单链表中删除倒数第k个节点
        ListNode head = removeLastKthNode(head1, 2);
        while (head != null) {
            System.out.print(" "+head.values);
            head = head.nextNode;
        }
    }
}

// 链表节点类
class ListNode {
    public int values;
    public ListNode nextNode;

    public ListNode(int data) {
        this.values = data;
    }

}