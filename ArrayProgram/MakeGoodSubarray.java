package ArrayProgram;

import java.util.ArrayList;
import java.util.List;

public class MakeGoodSubarray {
    public static void main(String[] args) {
        int[] nums1 = {-5, 1, 3, -1, -4, 2, 4, 5};
        int[] result = makeGoodSubarray(nums1);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }  // Output: 1 -5 3 -1 2 -4 4 5
    public static int[] makeGoodSubarray(int[] nums) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        // Separate positive and negative elements
        for (int num : nums) {
            if (num > 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }
        int[] result = new int[nums.length];
        int posIdx = 0;
        int negIdx = 0;
        // Reconstruct the array with good subarray ordering
        for (int i = 0; i < result.length; i++) {
            if (i % 2 == 0 && posIdx < positive.size()) {
                result[i] = positive.get(posIdx++);
            } else if (negIdx < negative.size()) {
                result[i] = negative.get(negIdx++);
            }
        }

        return result;
    }
}
