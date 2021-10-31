package com.test.Medium;

public class L1476_SubrectangleQueries {

    class SubrectangleQueries {
        private int[][] rectangle;

        public SubrectangleQueries(int[][] rectangle) {
            this.rectangle = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            /*
            // method 1
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    this.rectangle[i][j] = newValue;
                }
            }*/
            for (int i = col1; i <= col2; i++) {
                this.rectangle[row1][i] = newValue;
            }
            for (int i = row1; i < row2; i++) {
                System.arraycopy(this.rectangle[i], col1,
                        this.rectangle[i + 1], col1, col2 - col1 + 1);
            }
        }

        public int getValue(int row, int col) {
            return this.rectangle[row][col];
        }
    }

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */
}
