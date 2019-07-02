package NumSequence;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class L_705_DesignHashSet {

    /*
        Design a HashSet without using any built-in hash table libraries.

        To be specific, your design should include these functions:

        add(value): Insert a value into the HashSet.
        contains(value) : Return whether the value exists in the HashSet or not.
        remove(value): Remove a value in the HashSet. If the value does not exist
        in the HashSet, do nothing.

        Example:
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.contains(1);    // returns true
        hashSet.contains(3);    // returns false (not found)
        hashSet.add(2);
        hashSet.contains(2);    // returns true
        hashSet.remove(2);
        hashSet.contains(2);    // returns false (already removed)

        Note:
        All values will be in the range of [0, 1000000].
        The number of operations will be in the range of [1, 10000].
        Please do not use the built-in HashSet library.

     */

    public static void main(String[] args) {
        MyHashSet hashSet = new L_705_DesignHashSet().new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));    // returns true
        System.out.println(hashSet.contains(3));    // returns false (not found)
        hashSet.add(2);
        System.out.println(hashSet.contains(2));    // returns true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));    // returns false (already removed)
    }



    class MyHashSet {

        /* // inspired by Discuss ...

        int bucketSize = 1000;
        int bucketLoad = 1001; //0 and 1000 would be same, so use 1001
        class Node {
            BitSet bs;
            Node() {
                bs = new BitSet(bucketLoad);
            }
        }

        final Node [] buckets = new Node[bucketSize];

        private int index(int k) {
            return (Integer.hashCode(k)) % bucketSize;
        }
        // Initialize your data structure here.
        public MyHashSet() {

        }

        public void add(int key) {
            int i = index(key);
            if(buckets[i]==null) buckets[i] = new Node();
            buckets[i].bs.set(key%bucketLoad);
        }

        public void remove(int key) {
            int i = index(key);
            if(buckets[i]==null) return;
            buckets[i].bs.clear(key%bucketLoad);
        }

        // Returns true if this set contains the specified element
        public boolean contains(int key) {
            int i = index(key);
            if(buckets[i]==null) return false;
            return buckets[i].bs.get(key%bucketLoad);
        }
*/
         //method1 ...

        private final int[] data;
        private static final int MAX = 1000000;

        // Initialize your data structure here.
        public MyHashSet() {
            data = new int[MAX];
        }

        public void add(int key) {
            data[key] = key + 1;
        }

        public void remove(int key) {
            data[key] = 0;
        }

        // Returns true if this set contains the specified element
        public boolean contains(int key) {
            return data[key] != 0;
        }
    }

    /**
     * Your MyHashSet object will be instantiated and called as such:
     * MyHashSet obj = new MyHashSet();
     * obj.add(key);
     * obj.remove(key);
     * boolean param_3 = obj.contains(key);
     */
}
