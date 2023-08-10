package ArrayProgram;

//TC : O(1), SC : O(1)
public class SecondLargestNumberInArray {
    static int findSecondLargest(int[] arr, int n) {
        int first_largest = 0;
        int second_largest = -1;

        /* Now update the values of first_largest and second_largest in
           each iteration as per the approach.
        */
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[first_largest]) {
                second_largest = first_largest;
                first_largest = i;
            } else if (arr[i] < arr[first_largest]) {
                if (second_largest == -1 || arr[second_largest] < arr[i]) {
                    second_largest = i;
                }
            }
        }
        return arr[second_largest];
    }

    public static void main(String[] args) {
        int[] arr = {12, 35, 10, 21, 34, 1};
        int n = arr.length;
        int answer = findSecondLargest(arr, n);
        System.out.println("The second largest element : " + answer);
    }
}

/*
Pseudo code can be:
1. Initialize the first_largest variable with 0 and the second_largest variable with the value -1
2. Start traversing the array and in each iteration check:
   i) If the current element in array i.e. a[i] is greater
      than the element at the index - first_largest or not. If it is greater then update:
      second_largest = first_largest
      first_largest = i
   ii) If the value of current element is in between first_largest and second_largest, then update :
      second_largest = i
3. Return the value stored at the second_largest index as the answer.
 */
