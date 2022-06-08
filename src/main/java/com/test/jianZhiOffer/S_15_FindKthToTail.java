package com.test.jianZhiOffer;

import com.test.ds.list.ListNode;

public class S_15_FindKthToTail {

    public ListNode<Integer> findKthToTail(ListNode<Integer> head, int k) {
        if (null == head || 1 > k) return null;
        ListNode<Integer> targetNode;
        for (ListNode<Integer> cursor = targetNode = head; null != cursor; cursor =cursor.getNext()) {
            if (0 == k) {
                targetNode = targetNode.getNext();
            } else {
                --k;
            }
        }
        return 0 == k ? targetNode : null;
    }

}
