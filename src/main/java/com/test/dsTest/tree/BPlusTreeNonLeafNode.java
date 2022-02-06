package com.test.dsTest.tree;

import com.alibaba.fastjson.JSON;
import lombok.Getter;

@Getter
public class BPlusTreeNonLeafNode extends BPlusTreeNode {

    private BPlusTreeNode[] pointer;

    public BPlusTreeNonLeafNode(int n) {
        key = new Object[n - 1];
        pointer = new BPlusTreeNode[n];
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }


}
