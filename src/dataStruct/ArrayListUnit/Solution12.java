package dataStruct.ArrayListUnit;

class Solution12 {
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head, slowPre = null;
        while (fast.next != null && fast.next.next != null) {
            slowPre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slowPre != null) slowPre.next = null;
        if (slow == null) return null;
        TreeNode node = new TreeNode(slow.val);
        if (head != slow) node.left = sortedListToBST(head);
        node.right = sortedListToBST(slow.next);
        return node;
    }

    public static void PreOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.val+" ");
            PreOrder(node.left);
            PreOrder(node.right);
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-10);
        ListNode l2 = new ListNode(-3);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;


        TreeNode node = Solution12.sortedListToBST(l1);
        Solution12.PreOrder(node);



    }
}