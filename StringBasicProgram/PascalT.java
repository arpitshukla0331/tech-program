package StringBasicProgram;

public class PascalT {
    public static void main(String[] args) {
        System.out.println("Output for 0,0: " + pascal(0, 0)); // Output: 1
        System.out.println("Output for 1,2: " + pascal(1, 2)); // Output: 2
        System.out.println("Output for 4,8: " + pascal(4, 8)); // Output: 70
    }

    public static int pascal(int col, int row) {
        if (col == 0 || col == row) {
            return 1;
        }

        return pascal(col - 1, row - 1) + pascal(col, row - 1);
    }
}
