package StringBasicProgram;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DemoPractice {

    public static void main(String[] args) {
        int i = 2;
        int y;
        i++;
        ++i;
        y = ++i + i++;
        System.out.println(i + " " + y);

        Map<Integer, String> map = new HashMap<>();
        map.put(0, "A");

        System.out.println(map);

        Map<Integer, String> map1 = new HashMap<>();

        map1.put(1, "A");
        System.out.println(map1.hashCode() == map.hashCode());

        ArrayList<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        list.add(1, "D");
        list.add(2, "E");
        System.out.println(list);


        //COUNT DUPLICATE ELEMENT in array :
        List<Integer> integerList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        Map<Integer, Integer> countDuplicateElement = integerList.stream()
                .collect(Collectors.toMap(Function.identity(), x -> 1, Integer::sum));
        System.out.println("its duplicate count : \n" + countDuplicateElement);

        Random random = new Random();
        random.ints().limit(5).sorted().forEach(System.out::println);

        Integer reduce = integerList.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

        List<Integer> newList = Arrays.asList(100, 100, 9, 8, 200);
        OptionalDouble average = newList.stream().mapToInt(x -> x * x).filter(x -> x > 50).average();

        if (average.isPresent())
            System.out.println(average.getAsDouble());

        System.out.println("--------------------------------------------------");


        LinkedHashSet<Integer> set = new LinkedHashSet<>(newList);
        set.add(11);
        System.out.println(set);

        int[] arr= {1,2,4,5,10};
        Arrays.sort(arr);
        int n = arr.length;
        int max= arr[n-1];
        System.out.println(max);


    }


}
