package ArrayProgram;

import java.util.HashMap;
import java.util.Map;

// TC : O(n), SC : O(n)
public class FrequencyEachNumberFromArray {
    public static void main(String[] args) {
        int[] arr = {10, 20, 20, 10, 10, 20, 5, 20};
        int n = arr.length;
        countFrequency(arr, n);
    }

    static void countFrequency(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.get(arr[i]) == null ? 1 : map.get(arr[i]) + 1);
        }
        //To print elements according to first
        // occurrence, traverse array one more time
        // print frequencies of elements and mark
        // frequencies as -1 so that same element
        // is not printed multiple times.
        for (int i = 0; i < n; i++) {
            if (map.get(arr[i]) != -1) {
                System.out.println(arr[i] + " : " + map.get(arr[i]));
                map.put(arr[i], -1);
            }
        }
    }
}
