package sword_offer.chap3;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTailInLinkedList {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 快慢指针思想，先将快指针移动k步，然后同时移动快慢指针
     */
    public ListNode FindKthToTail(ListNode head, int k){
        if(k <= 0 || head == null)
            return null;

        ListNode fast = head, slow = head;

        // 先将快指针移动k步
        while(k-->0){
            if(fast == null)
                return null;
            fast = fast.next;
        }

        // 同时移动快慢指针
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
