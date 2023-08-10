package StringBasicProgram;

public class CountVowels {

    public static void main(String[] args) {
        String s = "arpit";
        long count = s.chars().filter(i -> i=='a' || i=='e' || i=='i' || i=='o' || i=='u').count();
        System.out.println(count);

    }
}

