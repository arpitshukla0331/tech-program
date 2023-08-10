package ArrayProgram;

/*
Sample Input S1 = "JavaTpoint"; S2= "Tin"
Output: The valid substring is "Tpoin"
Two Pointer approach
 */
public class MinimumWindowSubstring {
    static String findMinWindow(String s1, String s2) {
        String window = "";
        int ptr2 = 0;
        int minimum = s1.length() + 1;

        for (int ptr1 = 0; ptr1 < s1.length(); ptr1++) {
            if (s1.charAt(ptr1) == s2.charAt(ptr2)) {
                ptr2 = ptr2 + 1;

                if (ptr2 == s2.length()) {
                    int x = ptr1 + 1;
                    ptr2 = ptr2 - 1;

                    while (ptr2 >= 0) {
                        if (s1.charAt(ptr1) == s2.charAt(ptr2)) {
                            ptr2 = ptr2 - 1;
                        }
                        ptr1 = ptr1 - 1;
                    }
                    ptr2 = ptr2 + 1;
                    ptr1 = ptr1 + 1;

                    if (x - ptr1 < minimum) {
                        minimum = x - ptr1;

                        window = s1.substring(ptr1, x);
                    }
                }
            }
        }
        return window;
    }

    public static void main(String[] args) {
        String s1 = "JavaTpoint";
        String s2 = "Tin";
        System.out.println("For the strings \"" + s1 + "\" and \"" + s2 + "\"");
        System.out.println("The minimum window is :" + findMinWindow(s1, s2));
    }
}
