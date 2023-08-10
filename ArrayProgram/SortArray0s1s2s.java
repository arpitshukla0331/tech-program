package ArrayProgram;
import java.util.Arrays;

public class SortArray0s1s2s {
    public static void main(String[] args) {
        int [] arr= {0,1,2,0,2,1};
        int low=0, mid= 0;
        int n = arr.length;
        int high = n-1;
        while (mid<=high) {
            if(arr[mid]==0) {
                int temp = arr[low];
                arr[low]= arr[mid];
                arr[mid]= temp;
                low++;
                mid++;
            }
            if(arr[mid]==1)
                mid++;
            if(arr[mid]==2){
                int temp = arr[mid];
                arr[mid]= arr[high];
                arr[high]= temp;
                high= high-1;
            }
        }
        System.out.println("SortArray with :" + Arrays.toString(arr));
    }
}
/**
 * The basic idea of this approach is to place all the zeros on the left of the array and the 2s on the right while
 * keeping the 1s at the center of the array, and all this is possible in only a single traversal of the array making
 * the time complexity of this approach a perfect O(N) i.e. without any coefficient attached to it.
 */
