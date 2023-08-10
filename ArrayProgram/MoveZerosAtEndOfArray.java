package ArrayProgram;

public class MoveZerosAtEndOfArray {
    static void shiftZerosAtEnd(int[] arr, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0)
                arr[count++] = arr[i];
        }
        while (count < n) {
            arr[count++] = 0;
        }
        //System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 0, 6, 1, 8};
        int n = arr.length;
        shiftZerosAtEnd(arr, n);
        System.out.println("Array after pushing zeros to the back: ");
        for (int j : arr) System.out.print(j + " ");

    }

}

