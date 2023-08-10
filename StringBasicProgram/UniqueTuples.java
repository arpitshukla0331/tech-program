package StringBasicProgram;

import java.util.HashSet;

public class UniqueTuples {
    public static void main(String[] args) {
        String input = "abbccde";
        int len = 2;
        HashSet<String> tuples = uniqueTuples(input, len);

        System.out.println(tuples); // Output: [bc, bb, cd, ab, cc, de]
    }

    public static HashSet<String> uniqueTuples(String input, int len) {
        HashSet<String> result = new HashSet<>();

        for (int i = 0; i <= input.length() - len; i++) {
            String tuple = input.substring(i, i + len);
            result.add(tuple);
        }

        return result;
    }
}
