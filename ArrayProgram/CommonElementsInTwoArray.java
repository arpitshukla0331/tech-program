package ArrayProgram;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CommonElementsInTwoArray {
    public static void main(String[] args) {
        List<Integer> first = Arrays.asList(1, 3, 1, 6, 5, 7, 3);
        List<Integer> second = Arrays.asList(2, 3, 4, 5, 3);
        Set<Integer> set = findCommonElements(first,second);
        System.out.println(set);
    }
    static <T> Set<T> findCommonElements(List<T> first, List<T> second) {
        return first.stream().filter(second::contains).collect(Collectors.toSet());
    }
}
