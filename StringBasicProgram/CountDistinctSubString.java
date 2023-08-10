package StringBasicProgram;

import java.util.HashSet;

//TC : O(n*n) ; SC : O(n)
public class CountDistinctSubString {
    static void printSubString(String str) {
        HashSet<String> set = new HashSet<>();
        for(int i =0; i<str.length(); ++i){
            String s = "";
            for(int j =1;j<str.length(); ++j) {
                s= s + str.charAt(j);
                set.add(s);
            }
        }
        for(String strNew : set){
            System.out.println(strNew + " ");        }
    }

    public static void main(String[] args) {
        String str= "abbccde";
        printSubString(str);
    }
}
