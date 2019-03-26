package utils;

public class PrintUtil {

    public static void printArray(int[] a) {
        if (null != a) {
            for (int aa : a) {
                System.out.print(aa + " ");
            }
            System.out.println("\n ------------------ ");
        }
    }


    public static void printArray(int[][] a) {
        if (null != a) {
            for (int[] aa : a) {
                for (int aaa : aa)
                    System.out.print(aaa + " ");
                System.out.println();
            }
            System.out.println(" ------------------ ");
        }
    }
}
