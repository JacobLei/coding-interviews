package chap2;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 输入一个链表的头节点，从尾到头打印链表每个节点的值。
 */
public class PrintListFromTailToHead {
    private class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val){
            this.val = val;
        }
    }

    /**
     * 借组栈来时链表值的顺序从尾部到头部打印
     * @param listNode  链表的头节点
     * @return 从尾到头排序的结点
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        LinkedList<Integer> stack = new LinkedList<>();

        for (ListNode node = listNode; node != null; node = node.next){
            stack.push(node.val);
        }

        return new ArrayList<>(stack);
    }

    /**
     * 利用递归，先递归到最后一个结点后开始依次返回。
     * 链表如果很长不适合用递归，递归深度将很大
     */
    private ArrayList<Integer> res = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if(listNode != null){
            printListFromTailToHead2(listNode.next);
            res.add(listNode.val);
        }

        return res;
    }

}
