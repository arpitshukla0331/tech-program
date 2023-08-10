package ArrayProgram;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr = {8, -2, 4, 7, 6, 5, 1};
        int count = 1, n = arr.length;
        int max = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > max) {
                count++;
                max = arr[i];
            }
        }
        System.out.println(count);

    }
}
