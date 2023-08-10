package ArrayProgram;

//TC :O(N); SC: O(1)
public class CountGreaterElementThanItself {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 4, 8, 0, 8, 1, 3, 8};
        System.out.println(getElements(arr));
    }

    public static int getElements(int[] arr) {
        int maxVal = arr[0];
        int cnt = 0;
        for (int j : arr) {
            if (maxVal < j) {
                maxVal = j;
            }

            if (j == maxVal) {
                cnt++;
            }
        }
        return (arr.length - cnt);
    }
}
