package com.test.dsTest.tree;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Entry<K, V> {

    private K key;

    private V value;


}
