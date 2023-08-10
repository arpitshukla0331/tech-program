package ArrayProgram;

public class ClosestMinAndMaxInSubArray {

    public static class ClosetMinAndMaxInSubArray {
        public static void main(String[] args) {
            int[] A = {1, 2, 3, 1, 3, 4, 6, 4, 6, 3};
            int n = A.length;
            int closest = getClosest(A, n);
            System.out.println(closest);
        }

        public static int getClosest(int[] A, int n) {
            int minValue = A[0];
            for (int i = 1; i < n; i++) {
                if (A[i] < minValue)
                    minValue = A[i];
            }
            int maxValue = A[0];
            for (int i = 1; i < n; i++) {
                if (A[i] > maxValue)
                    maxValue = A[i];
            }

            int pos_min = -1, pos_max = -1,
                ans = Integer.MAX_VALUE;

            // iterate over the array and set answer
            // to the smallest difference between position
            // of maximum and position of minimum value
            for (int i = 0; i < n; i++) {

                // last occurrence of minValue
                if (A[i] == minValue)
                    pos_min = i;

                // last occurrence of maxValue
                if (A[i] == maxValue)
                    pos_max = i;

                if (pos_max != -1 && pos_min != -1)
                    ans = Math.min(ans,
                        Math.abs(pos_min - pos_max) + 1);
            }

            return ans;
        }
    }
}

