package ArrayProgram;
import java.util.*;
public class SecondMostFrequentElement {
    public static int find(int[] numbers) {
        int secondMostRepeating = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for (int number : numbers) {
            if (map.containsKey(number)) {
                count = map.get(number);
                map.put(number, ++count);
            } else {
                map.put(number, 1);
            }
        }
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : set) {
            if (entry.getValue() >= max) {
                max = entry.getValue();
            } else if (entry.getValue() >= second) {
                second = entry.getValue();
                secondMostRepeating = entry.getKey();
            }
        }
        return secondMostRepeating;
    }
    public static void main(String[] args) {
        int[] numbers = {2,3,1,2,2,4,3};
        System.out.println(find(numbers));
    }
}