package StringBasicProgram;

public class CountEachWordOccurrence {
    //Complexity will be : O(n*n)
    public static void main(String[] args) {
        String str = "my name is John";
        int[] count = new int[str.length()];
        char[] str1 = str.toCharArray();
        for(int i =0; i<str.length(); i ++) {
            count[i]=1;
            for(int j =i+1; j <str.length(); j++) {
                if(str1[i] == str1[j]) {
                    count[i]++;
                }
            }
        }
        for(int i =0; i<count.length; i++) {
            if(str1[i]!= ' ' && str1[i] != '0') {
                System.out.println("count word :" + str1[i] + " " + count[i]);
            }
        }
    }
}
