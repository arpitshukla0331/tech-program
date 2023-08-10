package ArrayProgram;

import java.util.Scanner;

public class SecondSmallest {
    public static void main(String[] args) {
        int[] arr= {-1, 0, 1, -2, 2};
        System.out.println(sec_least(arr));
    }
    public static int sec_least(int[] arr) {
        int least = Integer.MAX_VALUE; //least
        int sleast = Integer.MAX_VALUE;  //second least


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < least) {
                sleast = least;
                least = arr[i];
            } else if (arr[i] < sleast) {
                sleast = arr[i];
            }
        }

        return sleast;
    }
}
