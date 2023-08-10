package StringBasicProgram;

import java.util.stream.IntStream;

public class PalindromeWithLambda {

    public static void main(String[] args) {
        int num = 121;
        String temp = Integer.toString(num);
        boolean val = IntStream.range(0,temp.length()/2)
                .noneMatch(i -> temp.charAt(i) != temp.charAt(temp.length()-i-1));
        System.out.println("number is Palindrome:  " +val);

        String str = "abcba";
        String tempNew = str.replaceAll("\\s+","");
        boolean b = IntStream.range(0, tempNew.length() / 2)
                .noneMatch(i -> tempNew.charAt(i) != tempNew.charAt(tempNew.length() - i - 1));
        System.out.println("String is Palindrome :" + b);


    }


}
