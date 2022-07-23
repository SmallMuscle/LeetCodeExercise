package com.test.base;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

    @Test
    public void arrayTestz() {
        List<int[]> list = new LinkedList<>();
        list.add(new int[] {1, 2});
        list.add(new int[] {2, 3});
        list.toArray();
    }

    public void max(int a, int b) {

    }

    @Test
    public void genericityTest() {
        List<String> list = new ArrayList<>();
        //List<Object> objList = list;
    }
}
