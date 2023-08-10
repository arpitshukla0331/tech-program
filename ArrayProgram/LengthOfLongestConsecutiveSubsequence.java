package ArrayProgram;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LengthOfLongestConsecutiveSubsequence {
    /*** Input : [2, 0, 6, 1, 5, 3, 7]
     * Output: 4
     * Explanation: The longest subsequence formed by the consecutive integers
     * is [2, 0, 1, 3]. It has distinct values
     * and length 4.*/
    static int maxLongestLength(int[] arr) {
         Set<Integer> set = IntStream.of(arr).boxed().collect(Collectors.toSet());
         int maxLength = 0;
         for(int e :arr) {
             if(!set.contains(e-1)){
                 int length = 1;
                 while (set.contains(e+length)){
                     length++;
                 }
                 maxLength= Math.max(maxLength, length);
             }
         }
        return maxLength;
    }

    public static void main(String[] args) {
        //int[] arr = {2, 0, 6, 1, 5, 3, 7};
        int[] arr = {11,7,1,17,6,2,3,16,8,4,9,10,15};
        System.out.println("The length of the maximum consecutive subsequence is :" + maxLongestLength(arr));
    }
}
