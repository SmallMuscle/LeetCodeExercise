package com.test.dsTest.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class BPlusTree<K, V> {

    private BPlusTreeNode root;

    private int n;

    public BPlusTree() {
        int n = 4;
        if (n < 1) {
            throw new RuntimeException("B+ tree constructor param n must greater than 0");
        }
        this.n = n;
    }

    public int add(K key, V value) {
        if (null == key) {
            throw new NullPointerException("key must not be be null");
        }
        if (null == root) {
            root = new BPlusTreeLeafNode(this.n);
        }
        BPlusTreeNode node = root;
        Comparable<? super  K> comparable = (Comparable<? super K>) key;
        Map<BPlusTreeNode, BPlusTreeNode> parents = new HashMap<>();
        // find leaf node
        while (! (node instanceof BPlusTreeLeafNode)) {
            BPlusTreeNonLeafNode nonLeaf = (BPlusTreeNonLeafNode) node;
            parents.put(nonLeaf.getPointer()[0], nonLeaf);
            for (int i = 0; i < nonLeaf.getKey().length; ++i) {
                K nodeKey = (K) nonLeaf.getKey()[i];
                if (null == nodeKey) {
                    node = nonLeaf.getPointer()[i];
                    break;
                } else {
                    parents.put(nonLeaf.getPointer()[i + 1], nonLeaf);
                    int cmp = comparable.compareTo(nodeKey);
                    if (0 >= cmp) {
                        node = nonLeaf.getPointer()[i];
                        break;
                    }
                    if (nonLeaf.getKey().length == i + 1) {
                        node = nonLeaf.getPointer()[nonLeaf.getKey().length];
                        break;
                    }
                }
            }
        }
        // insert to leaf
        Comparable<? super V> valueComparable = (Comparable<? super V>) value;
        BPlusTreeLeafNode leaf = (BPlusTreeLeafNode) node;
        if (null == leaf.getKey()[leaf.getKey().length - 1]) {
            // non split
            for (int i = 0; i < leaf.getKey().length; i++) {
                K leafKey = (K) leaf.getKey()[i];
                if (null == leafKey) {
                    leaf.getKey()[i] = key;
                    leaf.getValue()[i] = value;
                    break;
                } else {
                    int cmp = comparable.compareTo(leafKey);
                    if (0 > cmp) {
                        System.arraycopy(leaf.getKey(), i, leaf.getKey(), i + 1, n - 2 - i );
                        System.arraycopy(leaf.getValue(), i, leaf.getValue(), i + 1, n - 2 - i );
                        leaf.getKey()[i] = key;
                        leaf.getValue()[i] = value;
                        break;
                    }
                    // TODO 多 key 相同的情况
                }
            }
        } else {
            // split
            BPlusTreeLeafNode newLeaf = null;
            int splitLen = n >> 1;
            int splitIndex = splitLen - 1;
            for (int i = 0; i < splitLen; i++) {
                K leafKey = (K) leaf.getKey()[i];
                int cmp = comparable.compareTo(leafKey);
                if (0 > cmp) {
                    newLeaf = new BPlusTreeLeafNode(n);
                    System.arraycopy(leaf.getKey(), splitIndex , newLeaf.getKey(), 0, splitLen );
                    System.arraycopy(leaf.getValue(), splitIndex, newLeaf.getValue(), 0, splitLen);
                    for (int j = leaf.getKey().length - 1; j >= i ; --j) {
                        if (j >= splitIndex) {
                            leaf.getKey()[j] = leaf.getValue()[j] = null;
                            continue;
                        }
                        leaf.getKey()[j + 1]  = leaf.getKey()[j];
                        leaf.getValue()[j + 1]  = leaf.getValue()[j];
                        if (j == i) {
                            leaf.getKey()[j] = key;
                            leaf.getValue()[j] = value;
                        }
                    }
                    break;
                }
            }
            if (null == newLeaf) {
                newLeaf = new BPlusTreeLeafNode(n);
                int i = 0;
                int gap = 0;
                for (; i < splitIndex; i++) {
                    int leafIndex = splitLen + i;
                    int newLeafIndex = i + gap;
                    K leafKey = (K) leaf.getKey()[leafIndex];
                    int cmp = comparable.compareTo(leafKey);
                    if (0 < cmp) {
                        newLeaf.getKey()[newLeafIndex] = leaf.getKey()[leafIndex];
                        newLeaf.getValue()[newLeafIndex] = leaf.getValue()[leafIndex];
                        leaf.getKey()[leafIndex] = leaf.getValue()[leafIndex] = null;
                        continue;
                    }
                    if (0 > cmp) {
                        newLeaf.getKey()[newLeafIndex] = key;
                        newLeaf.getValue()[newLeafIndex] = value;
                        ++gap;
                    }
                }
                if (0 == gap) {
                    newLeaf.getKey()[splitIndex] = key;
                    newLeaf.getValue()[splitIndex] = value;
                }
            }
            // deal with pointer
            newLeaf.setNext(leaf.getNext());
            leaf.setNext(newLeaf);
            insertParent(leaf, (K) newLeaf.getKey()[0], newLeaf, parents);
        }
        return 1;
    }

    private void insertParent(BPlusTreeNode node, K midKey, BPlusTreeNode newNode, Map<BPlusTreeNode, BPlusTreeNode> parents) {
        if (root == node) {
            BPlusTreeNonLeafNode newRoot = new BPlusTreeNonLeafNode(n);
            newRoot.getKey()[0] = midKey;
            newRoot.getPointer()[0] = node;
            newRoot.getPointer()[1] = newNode;
            root = newRoot;
        } else {
            int nodeIndex = 0;
            BPlusTreeNonLeafNode parent = (BPlusTreeNonLeafNode) parents.get(node);
            for (; nodeIndex < parent.getPointer().length && node != parent.getPointer()[nodeIndex]; nodeIndex++);
            if (nodeIndex == parent.getPointer().length) {
                throw new RuntimeException("data error: parent " + parent + " not found node " + node);
            }
            if (null == parent.getKey()[parent.getKey().length - 1]) {
                // only insert
               System.arraycopy(parent.getKey(), nodeIndex, parent.getKey(), nodeIndex + 1, n - 2 - nodeIndex);
               System.arraycopy(parent.getPointer(), nodeIndex + 1, parent.getPointer(), nodeIndex + 2, n - 2 - nodeIndex);
               parent.getKey()[nodeIndex] = midKey;
               parent.getPointer()[nodeIndex + 1] = newNode;
            } else {
                // split parent
                BPlusTreeNonLeafNode newParent = new BPlusTreeNonLeafNode(n);
                K midParentKey = null;
                int midIndex = n >> 1;
                if (nodeIndex == midIndex) {
                    midParentKey = midKey;
                    newParent.getPointer()[0] = newNode;
                    for (int i = midIndex; i < parent.getKey().length; i++) {
                        newParent.getKey()[i - midIndex] = parent.getKey()[i];
                        newParent.getPointer()[i - midIndex + 1] = parent.getPointer()[i + 1];
                        parent.getKey()[i] = parent.getPointer()[i + 1] = null;
                    }
                } else if (nodeIndex > midIndex) {
                    midParentKey = (K) parent.getKey()[midIndex];
                    newParent.getPointer()[0] = parent.getPointer()[midIndex + 1];
                    parent.getKey()[midIndex] = parent.getPointer()[midIndex + 1] = null;
                    for (int i = 1, gap = 0; i < midIndex; i++) {
                        int parentKeyIndex = midIndex + 1;
                        if (nodeIndex == parentKeyIndex + 1) {
                            newParent.getKey()[i - 1] = midKey;
                            newParent.getPointer()[i] = newNode;
                            gap = 1;
                        } else {
                            newParent.getKey()[i - 1] = parent.getKey()[parentKeyIndex + gap];
                            newParent.getPointer()[i] = parent.getPointer()[parentKeyIndex + 1 + gap];
                            parent.getKey()[parentKeyIndex + gap] = parent.getPointer()[parentKeyIndex + 1 + gap] = null;
                        }
                    }
                } else {
                    midParentKey = (K) parent.getKey()[midIndex - 1];
                    newParent.getPointer()[0] = parent.getPointer()[midIndex];
                    parent.getKey()[midIndex - 1] = parent.getPointer()[midIndex] = null;
                    for (int i = 1; i < midIndex; i++) {
                        newParent.getKey()[i - 1] = parent.getKey()[midIndex + i - 1];
                        newParent.getPointer()[i] = parent.getPointer()[midIndex + i];
                        parent.getKey()[midIndex + i - 1] = parent.getPointer()[midIndex + i] = null;
                    }
                }
                insertParent(parent, midParentKey, newParent, parents);
            }
        }
    }

    public List<Entry<K, V>> get(Object key) {
        if (null == key) {
            throw new NullPointerException("key must not be null");
        }
        BPlusTreeNode node = root;
        Comparable<? super K> comparable = (Comparable<? super K>) key;
        while (null != node && ! (node instanceof BPlusTreeLeafNode)) {
            BPlusTreeNonLeafNode nonLeaf = (BPlusTreeNonLeafNode) node;
            for (int i = 0; i < nonLeaf.getKey().length; ++i) {
                K nodeKey = (K) nonLeaf.getKey()[i];
                if (null == nodeKey) {
                    node = nonLeaf.getPointer()[i];
                    break;
                } else {
                    int cmp = comparable.compareTo(nodeKey);
                    if (0 >= cmp) {
                        node = nonLeaf.getPointer()[i];
                        break;
                    }
                    if (nonLeaf.getKey().length == i + 1) {
                        node = nonLeaf.getPointer()[nonLeaf.getKey().length];
                        break;
                    }
                }
            }
        }
        if (null != node) {
            BPlusTreeLeafNode leaf = (BPlusTreeLeafNode) node;
            List<Entry<K, V>> result = new ArrayList<>();
            for (int i = 0; i < leaf.getKey().length; ++i) {
                K leafKey = (K) leaf.getKey()[i];
                if (null == leafKey) {
                    break;
                } else {
                    int cmp = comparable.compareTo(leafKey);
                    if (0 < cmp ) {
                        break;
                    }
                    if (0 == comparable.compareTo(leafKey)) {
                        result.add(new Entry(leafKey, (V) leaf.getValue()[i]));
                    }
                }
                if (i + 1 == leaf.getKey().length && null != leaf.getNext()) {
                    i = 0;
                    leaf = leaf.getNext();
                }
            }
            return result;
        }
        return Collections.emptyList();
    }

    public int delete(K key) {
        return 0;
    }

}
