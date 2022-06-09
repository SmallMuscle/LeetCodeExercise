package com.test.jianZhiOffer;

public class S_24_VerifySequenceOfBST {

    public boolean verifySequenceOfBST(int[] sequence) {
        if (null == sequence || 0 == sequence.length) return false;
        return verifySequenceOfBSTCore(sequence, 0, sequence.length - 1);
    }

    public boolean verifySequenceOfBSTCore(int[] sequence, int start, int end) {
         if (start == end) return true;
        int root = sequence[end];
        int rightEnd = end - 1;
        int rightStart = end;
        for (int i = rightEnd; i >= start && root < sequence[i]; --i) rightStart = i;
        boolean right = true;
        if (rightStart <= rightEnd) right = verifySequenceOfBSTCore(sequence, rightStart, rightEnd);
        for (int i = start; i < rightStart; ++i) {
            if (root < sequence[i]) return false;
        }
        boolean left = true;
        if (start <= rightStart - 1) {
            left = verifySequenceOfBSTCore(sequence, start, rightStart - 1);
        }
        return left && right;
    }

}
