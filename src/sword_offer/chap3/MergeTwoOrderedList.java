package sword_offer.chap3;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表.
 * 当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeTwoOrderedList {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        ListNode res = null, node = null;

        if(list1.val <= list2.val){
            res = list1;
            node = list1;
            list1 = list1.next;
        }else{
            res = list2;
            node = list2;
            list2 = list2.next;
        }

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                node.next = list1;
                list1 = list1.next;
            }else{
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        while(list1 != null){
            node.next = list1;
            node = node.next;
            list1 = list1.next;
        }

        while(list2 != null){
            node.next = list2;
            node = node.next;
            list2 = list2.next;
        }

        return res;
    }
}
