package com.test.Easy;

public class L_812_LargestTriangleArea {

    /*
        You have a list of points in the plane. Return the area of the largest triangle that
        can be formed by any 3 of the points.

        Example:
            Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
            Output: 2
            Explanation:
                The five points are show in the figure below. The red triangle is the largest.
                    com.test.images/Example_L_812_LargestTriangleArea.png
        Notes:
            3 <= points.length <= 50.
            No points will be duplicated.
             -50 <= points[i][j] <= 50.
            Answers within 10^-6 of the true value will be accepted as correct.

     */

    public static void main(String[] args) {
        L_812_LargestTriangleArea l = new L_812_LargestTriangleArea();
        int [][] points1 = {{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}};
        System.out.println(l.largestTriangleArea(points1));
        int [][] points2 = {{0, 0}, {0, 1}, {1, 0}};
        System.out.println(l.largestTriangleArea(points2));
        int [][] points3 = {{8, 3}, {5, 6}, {3, 5}};
        System.out.println(l.largestTriangleArea(points3));
    }

    public double largestTriangleArea(int[][] points) {
        return largestTriangleArea1(points);
    }

    public double largestTriangleArea1(int[][] points) {
        double maxArea = 0;
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    double tmpArea = calculationArea(points[i], points[j], points[k]);
                    if (tmpArea > maxArea) maxArea = tmpArea;
                }
            }
        }
        return maxArea;
    }

    private double calculationArea(int[] point1, int[] point2, int[] point3) {
        double area = (point1[0] * point2[1] + point2[0]  * point3[1] + point3[0] * point1[1] -
                point1[1] * point2[0] - point2[1]  * point3[0] - point3[1] * point1[0]) / 2.0;
        return area > 0 ? area : - area;
    }
}
