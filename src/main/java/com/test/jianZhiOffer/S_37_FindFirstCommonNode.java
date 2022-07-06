package com.test.jianZhiOffer;

import com.test.ds.list.ListNode;

public class S_37_FindFirstCommonNode {

    public ListNode<Integer> findFirstCommonNode(ListNode<Integer> l1, ListNode<Integer> l2) {
        int len1 = getListLength(l1);
        int len2 = getListLength(l2);
        if (0 == len1 || 0 == len2) return null;
        int lenDiff = len1 - len2;
        ListNode<Integer> longList = l1;
        ListNode<Integer> shortList = l2;
        if (len2 > len1) {
            longList = l2;
            shortList = l1;
            lenDiff = len2 - len1;
        }
        while (lenDiff-- > 0) longList = longList.getNext();
        while (null != longList && longList != shortList) {
            longList = longList.getNext();
            shortList = shortList.getNext();
        }
        return longList;
    }

    private int getListLength(ListNode<Integer> head) {
        int result = 0;
        if (null != head) {
            for (ListNode<Integer> cur = head; null != cur; cur = cur.getNext()) ++result;
        }
        return result;
    }

}
