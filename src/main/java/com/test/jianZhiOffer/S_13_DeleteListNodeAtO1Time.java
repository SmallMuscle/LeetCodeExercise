package com.test.jianZhiOffer;

import com.test.ds.list.LinkedList;
import com.test.ds.list.ListNode;

public class S_13_DeleteListNodeAtO1Time {

    /**
     * delete toBeDelete listNode from list
     * toBeDelete node must be in list
     * [(n - 1 ) * O(1) + O(n)] / n = O(1)
     * @param list, must contain an empty head node.
     * @param toBeDelete
     */
    public void deleteNode(LinkedList<Integer> list, ListNode<Integer> toBeDelete) {
        if (null == list || null == list.getHead() || null == toBeDelete) return ;
        // tail node
        if (null == toBeDelete.getNext()) {
            for (ListNode<Integer> cursorNode = list.getEmptyHead(); null != cursorNode.getNext(); cursorNode = cursorNode.getNext()) {
                if (toBeDelete == cursorNode.getNext()) {
                    cursorNode.setNext(null);
                    break;
                }
            }
        } else {
            ListNode<Integer> realDelNode = toBeDelete.getNext();
            toBeDelete.setData(realDelNode.getData());
            toBeDelete.setNext(realDelNode.getNext());
            realDelNode.setNext(null);
        }
    }

}
