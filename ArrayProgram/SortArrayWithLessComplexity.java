package ArrayProgram;

public class SortArrayWithLessComplexity {
    static void sortArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i + 1) {
                i++;
            } else {
                int temp1 = arr[i];
                int temp2 = arr[arr[i] - 1];
                arr[i] = temp2;
                arr[temp1 - 1] = temp1;
            }
        }
    }

    public static void printArray(int[] arr)
    {
        // Traverse the array
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 5, 3};
       sortArray(arr);
       printArray(arr);
    }
}
