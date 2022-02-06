package com.test.dsTest.tree;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

@Getter
public class BPlusTreeLeafNode extends BPlusTreeNode {

    private Object[] value;

    @Setter
    private BPlusTreeLeafNode next;

    BPlusTreeLeafNode(int n) {
        key = new Object[--n];
        value = new Object[n];
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
