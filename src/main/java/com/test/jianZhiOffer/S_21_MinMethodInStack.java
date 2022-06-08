package com.test.jianZhiOffer;

public class S_21_MinMethodInStack {

    class Stack<E> {

        Object[] arrays = {};
        Object[] minArrays = {};
        // used for toString
        int[] longestArrays = {};

        int num = 0;

        public Stack() {}

        public Stack(int size) {
            if (0 > size) throw new RuntimeException("The size must greater than or equal to 0.");
            if (0 != size) {
                arrays = new Object[size];
                minArrays = new Object[size];
                longestArrays = new int[size];
            }
        }

        public boolean isEmpty() {
            return 0 == num;
        }

        public E pop() {
            if (isEmpty()) throw new RuntimeException("Already empty.");
            return (E) arrays[--num];
        }

        public void push(E e) {
            if (num == arrays.length) throw new RuntimeException("Already full");
            if (null == e) throw new NullPointerException("Push Element must not be null.");
            int eLen = String.valueOf(e).length();
            if (0 == num) {
                minArrays[num] = e;
                longestArrays[num] = eLen;
            } else {
                Comparable<? super E> element = (Comparable<? super E>) e;
                E lastMin = (E) minArrays[num - 1];
                minArrays[num] = 0 > element.compareTo(lastMin) ? e : lastMin;
                longestArrays[num] = Math.max(eLen, longestArrays[num - 1]);
            }
            arrays[num++] = e;
        }

        public E min() {
            return 0 == num ? null : (E) minArrays[num - 1];
        }

        @Override
        public String toString() {
            if (isEmpty()) {
                return "\n\t└╌╌╌╌╌┘";
            }
            int width = longestArrays[num - 1] + 2;
            StringBuilder buffer = new StringBuilder();
            for (int elementIndex = num - 1; elementIndex >= 0; --elementIndex) {
                buffer.append("\n\t├");
                for (int i = width; i > 0; --i) buffer.append('╌');
                buffer.append("┤");
                buffer.append("\n\t│");
                int currentElementLength = String.valueOf(arrays[elementIndex]).length();
                int firstBlankNum = (width - currentElementLength) >> 1;
                int lastBlankNum = width - currentElementLength - firstBlankNum;
                for (int i = 0; i < firstBlankNum; i++) {
                    buffer.append(' ');
                }
                buffer.append(arrays[elementIndex]);
                for (int i = 0; i < lastBlankNum; i++) {
                    buffer.append(' ');
                }
                buffer.append('│');
            }
            buffer.append("\n\t└");
            for (int i = width; i > 0; --i) buffer.append('╌');
            buffer.append("┘");
            return buffer.toString();
        }

    }

}
