package StringBasicProgram;

public class ReverseString {
    public static String reverseStr(String str) {
        StringBuilder reversed = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        String input = "abcd";
        String output = reverseStr(input);
        System.out.println("Output: " + output);  // Output: "dcba"
    }
}
