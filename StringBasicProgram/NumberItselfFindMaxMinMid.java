package StringBasicProgram;

public class NumberItselfFindMaxMinMid {
    public static void main(String[] args) {
        int number = 102;
        int j = 0;
        int[] arr = new int[String.valueOf(number).length()];
        while (number > 0) {
            int remainder = number % 10;
            arr[j++] = remainder;
            number = number / 10;
        }
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr.length; k++) {
                if (arr[i] < arr[k]) {
                    temp = arr[k];
                    arr[k] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println("MAX " + arr[2] + "" + arr[1] + "" + arr[0]);
        System.out.println("MIN " + arr[0] + "" + arr[1] + "" + arr[2]);
        System.out.println("MID " + arr[1] + "" + arr[0] + "" + arr[2]);
    }
}
