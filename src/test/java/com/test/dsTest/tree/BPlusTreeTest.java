package com.test.dsTest.tree;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class BPlusTreeTest {

    @Test
    public void addTest() {
        BPlusTree<String, String> tree = new BPlusTree<>();
        tree.add("alarm", "alarm");
        tree.add("brown", "brown");
        tree.add("call", "call");
        tree.add("car", "car");
        tree.add("elen", "elen");
        tree.add("flutter", "flutter");
        tree.add("gold", "gold");
        tree.add("kai", "kai");
        tree.add("kim", "kim");
        tree.add("mozart", "mozart");
        tree.add("single", "single");
        tree.add("switch", "switch");
        tree.add("wu", "wu");

        tree.add("lan", "lan");
    }


}
