package com.test.ds;

public class Pile<T> {

    int size = 0;
    boolean big = false;
    private Object[] data = {};

    public Pile(int capacity, boolean big) {
        if (capacity < 0) throw new IllegalArgumentException("Pile size must greater than 0.");
        this.data = new Object[capacity];
        this.big = big;
    }

    public int add(T e) {
        if (isFull()) return 0;
        data[size++] = e;
        upward();
        return 1;
    }

    public T getHead() {
        return isEmpty() ? null : (T) data[0];
    }

    public boolean isEmpty() {
        return 0 == size;
    }

    public boolean isFull() {
        return size == data.length;
    }
    public T removeHead() {
        if (isEmpty()) return null;
        else {
            T result = (T) data[0];
            System.arraycopy(data, 1, data, 0, size - 1);
            --size;
            upward();
            return result;
        }
    }

    private void upward() {
        for (int i = size - 1; i > 0; --i) {
            int parentIndex = i >> 1;
            T parent = (T) data[parentIndex];
            Comparable<? super T> curr = (Comparable<? super T>) data[i];
            int compareResult = curr.compareTo(parent);
            boolean swap = big ? (compareResult > 0) : (compareResult < 0);
            if (swap) {
                data[parentIndex] = data[i];
                data[i] = parent;
            }
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        else {
            StringBuilder buffer = new StringBuilder("[");
            for (int i = 0; i < size; i++) buffer.append(data[i]).append(", ");
            buffer.delete(buffer.length() - 2, buffer.length());
            return buffer.toString();
        }
    }

    public String toTreeString() {
        if (isEmpty()) return "";
        StringBuilder buffer = new StringBuilder("\n");
        int layer = 0;
        while (((1 << ++layer) - 1) < size) ;
        int maxLen = data[0].toString().length();
        for (int i = 1; i < size; i++) {
            int len = data[i].toString().length();
            if (len > maxLen) maxLen = len;
        }
        int interval = 1;
        for (int subLayer = 1; subLayer <= layer; ++subLayer) {
            int nodeNum = subLayer == layer ? (size - (1 << (layer - 1)) + 1) : 1 << (subLayer - 1);
            int blankNum = (((1 << (layer - subLayer)) - 1) * (maxLen + 2 + interval)) >> 1;
            // print slash
            if (1 != subLayer) {
                buffer.append('\t');
                boolean backSlash = false;
                for (int nodeIndex = 0; nodeIndex < nodeNum; ++nodeIndex) {
                    appendBlank(buffer, 0 == nodeIndex ? blankNum :
                            (subLayer == layer) ?  interval: ((blankNum + interval) << 1)
                                    - (((interval & 1) == 1) ? interval : interval - 1));
                    if (backSlash) {
                        buffer.append('\\');
                        appendBlank(buffer, 2 + maxLen - 1);
                        backSlash = false;
                    } else {
                        appendBlank(buffer, 2 + maxLen - 1);
                        buffer.append('/');
                        backSlash = true;
                    }
                }
                buffer.append('\n');
            }
            // print node
            buffer.append('\t');
            int nodeStart = (1 << (subLayer - 1)) - 1;
            for (int nodeIndex = 0; nodeIndex < nodeNum; ++nodeIndex) {
                appendBlank(buffer, 0 == nodeIndex ? blankNum :
                        (subLayer == layer) ?  interval: ((blankNum + interval) << 1)
                                - (((interval & 1) == 1) ? interval : interval - 1));

                T e = (T) data[nodeStart + nodeIndex];
                int eLen = e.toString().length();
                int beforeBlank = 0;
                int afterBlank = 0;
                if (maxLen != eLen) {
                    beforeBlank = (maxLen - eLen) >> 1;
                    afterBlank = maxLen - eLen - beforeBlank;
                }
                appendBlank(buffer, beforeBlank + 1);
                buffer.append(e);
                appendBlank(buffer, afterBlank + 1);
            }
            buffer.append('\n');
        }
        return buffer.toString();
    }

    private void appendBlank(StringBuilder buffer, int num) {
        for (int i = 0; i < num; i++) buffer.append(' ');
    }

}
