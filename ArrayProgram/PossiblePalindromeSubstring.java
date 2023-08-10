package ArrayProgram;

import java.util.HashSet;
import java.util.Set;

public class PossiblePalindromeSubstring {
    /**
     * Find all possible palindromic substrings of a string
     * Input:  str = google
     * Output: e l g o oo goog
     * O(n2) time and O(1) space.
     */
    public static void expand(String str, int low, int high, Set<String> set) {
        // run till `str[low.high]` is not a palindrome
        while (low >= 0 && high < str.length()
                && str.charAt(low) == str.charAt(high)) {
            // push all palindromes into a set
            set.add(str.substring(low, high + 1));
            // Expand in both directions
            low--;
            high++;
        }
    }

    // Function to find all unique palindromic substrings of a given string
    public static void findPalindromicSubstrings(String str) {
        // base case
        if (str == null) {
            return;
        }
        // create an empty set to store all unique palindromic substrings
        Set<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            // find all odd length palindrome with `str[i]` as a midpoint
            expand(str, i, i, set);
            // find all even length palindrome with `str[i]` and `str[i+1]`
            // as its midpoints
            expand(str, i, i + 1, set);
        }
        // print all unique palindromic substrings
        System.out.print(set);
    }

    public static void main(String[] args) {
        String str = "aabbbaa";
        findPalindromicSubstrings(str);
    }
}

