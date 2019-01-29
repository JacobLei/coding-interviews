package sword_offer.chap3;

/**
 * 输入一个链表的头结点，反转链表后，并返回反转链表的头结点。
 */
public class ReverseLinkedList {

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     *  分别用指针pre、node、next指针标识，然后旋转
     */
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        ListNode pre = null, node = head;

        while(node != null){
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }

        return pre;
    }
}
