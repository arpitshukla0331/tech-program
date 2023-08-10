package StringBasicProgram;

import java.util.*;

public class TripeltSumTarget {
//time complexity of the above solution is O(n2) and doesn’t require any extra space.
    public static void printAllTriplets(int[] arr, int target)
    {
        // sort the array in ascending order
        Arrays.sort(arr);
        int n = arr.length;
        // check if triplet is formed by nums[i] and a pair from
        // subarray nums[i+1…n)
        for (int i = 0; i <= n - 3; i++)
        {
            // remaining sum
            int k = target - arr[i];
            // maintain two indices pointing to endpoints of the subarray nums[i+1…n)
            int low = i + 1;
            int high = arr.length - 1;

            // loop if `low` is less than `high`
            while (low < high)
            {
                // increment `low` index if the total is less than the remaining sum
                if (arr[low] + arr[high] < k) {
                    low++;
                }

                // decrement `high` index if the total is more than the remaining sum
                else if (arr[low] + arr[high] > k) {
                    high--;
                }

                // triplet with the given sum is found
                else {
                    // print the triplet
                    System.out.println("(" + arr[i] + ", " + arr[low] + ", " +
                            arr[high] + ")");

                    // increment `low` index and decrement `high` index
                    low++;
                    high--;
                }
            }
        }
    }
    public static void main(String[] args)
    {
        int[] arr = { 2, 7, 4, 0, 9, 5, 1, 3 };
        int target = 6;

        printAllTriplets(arr, target);
    }

}
