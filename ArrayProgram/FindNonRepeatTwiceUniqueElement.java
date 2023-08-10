package ArrayProgram;

public class FindNonRepeatTwiceUniqueElement {
    static int getSingleElement(int[] arr, int n) {
        int result = arr[0];
        for (int i = 0; i < n; i++) {
            result = result ^ arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {7, 3, 5, 4, 5, 3, 4};
        int n = args.length;
        System.out.println("return unique element among common pair twice :"
                + getSingleElement(arr, n));
    }
}
