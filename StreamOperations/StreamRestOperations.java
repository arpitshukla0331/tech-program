package StreamOperations;



import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamRestOperations {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(41, 19, 1, 4, 11, 6);

        //count(), min(), max() methods using stream :
        Stream<Integer> stream = Stream.of(2, 5, 3, 1, 9, 6, 7);
        System.out.println("count the element--> " + stream.count());
        System.out.println("------------------------------------");

        Integer integer = Stream.of(2, 5, 3, 1, 9, 6, 7).min(Integer::compare).get();
        System.out.println("min element --> " + integer);

        Integer integer1 = Stream.of(2, 5, 3, 1, 9, 6, 7)
                .max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("max element --> " + integer1);

        //Summation of number in integer list
        int sum = list.stream().mapToInt(i -> i.intValue()).sum();
        System.out.println("summation of integer list : " + sum);

        //Number start with 1 itself
        list.stream().map(s-> s + " ").filter(s-> s.startsWith("1")).forEach(System.out::println);

        //Reverse a List
        Collections.reverse(list);
        System.out.println("reversed list : " + list);

        List<Integer> listOne = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> collect = listOne.stream().filter(x -> x > 5).map(x -> x * x).distinct().collect(Collectors.toList());
        System.out.println(collect);

        Integer integer2 = listOne.stream().map(e -> e.intValue()).sorted(Comparator.reverseOrder())
                .skip(2).findFirst().get();
        System.out.println(integer2);

        System.out.println("=============================");

        StreamRestOperations restOperations = new StreamRestOperations();
        restOperations.getName();

    }
    public void getName() {
        System.out.println("hello");
    }

    public static void m1() {
        System.out.println("hi");
    }
}
