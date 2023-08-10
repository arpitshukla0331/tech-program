package StreamOperations;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8ImportantQuestion {
    public static void main(String[] args) {

        //find out all the even numbers exist in the list using Stream functions?
        List<Integer> numberList = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
        numberList.stream().filter(x -> x % 2 == 0).forEach(System.out::println);
        System.out.println("-----------------------------------------------");

        //find out all the numbers starting with 1 using Stream functions?
        numberList.stream().map(s -> s + "").filter(s -> s.startsWith("1")).forEach(System.out::println);
        System.out.println("-----------------------------------------------");

        //find DUPLICATE NUMBERS in a given integers list in java using Stream functions?
        List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        Set<Integer> integerSet = new HashSet<>();
        list.stream().filter(x -> !integerSet.add(x)).forEach(System.out::println);
        System.out.println("-----------------------------------------------");

        //find DUPLICATE/COMMON WORD in a given string list in java using Stream functions?
        List<String> stringList = Arrays.asList("abc", "zxy", "pqo", "abc", "pqo");
        Set<String> stringSet = new HashSet<>();
        stringList.stream().filter(x -> !stringSet.add(x)).forEach(System.out::println);

        //COUNT EACH ELEMENT in array :
        List<Integer> integerList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        Map<Integer, Integer> countDuplicateElement = integerList.stream()
            .collect(Collectors.toMap(Function.identity(), x -> 1, Integer::sum));
        System.out.println("its duplicate count : \n" + countDuplicateElement);

        //Remove duplicate elements
        List<Integer> removeDup = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        List<Integer> collect = removeDup.stream().sorted().distinct().collect(Collectors.toList());
        System.out.println("remove duplicate elements :" + collect);

        // find the first element of the list using Stream functions?
        numberList.stream().findFirst().ifPresent(System.out::println);
        System.out.println("-----------------------------------------------");

        //find the SUM of total number of elements present in the list using Stream functions?
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println("Sum of all numbers in list: " + reduce);
        System.out.println("-----------------------------------------------");

        //find the MAXIMUM VALUE present in it using Stream functions?
        Integer maxNumber = list.stream().max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("Maximum number in list: " + maxNumber);
        System.out.println("-----------------------------------------------");

        //find the FIRST N0N-REPEATED CHARACTER in it using Stream functions?
        String str = "Java Hungry Blog Alive is Awesome";
        Character result = str.chars().mapToObj(c -> Character.toLowerCase((char) c))
            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
            .entrySet().stream().filter(entry -> entry.getValue() == 1L)
            .map(entry -> entry.getKey())
            .findFirst().get();
        System.out.println("First non repeated character: " + result);

        //find the FIRST REPEATED CHARACTER in it using Stream functions?
        Character resultNew = str.chars().mapToObj(c -> Character.toLowerCase((char) c))
            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
            .entrySet().stream().filter(entry -> entry.getValue() > 1L)
            .map(Map.Entry::getKey)
            .findFirst().get();
        System.out.println("First repeated character: " + resultNew);
        //Remove ADJACENT DUPLICATE PAIR in String
        String removeAdjacent = (new LinkedHashSet<Character>("scabbard".chars()
            .mapToObj(i -> (char) i).collect(Collectors.toList()))).stream()
            .map(e -> e.toString()).collect(Collectors.joining());
        System.out.println(removeAdjacent);

        //MISSING NUMBER in array using Stream
        int[] numbers = {2, 1, 6, 0, 3, 4};
        int N = 6;
        int idealSum = (N * (N + 1)) / 2;
        int sum = Arrays.stream(numbers).sum();
        int missingNumber = idealSum - sum;
        System.out.println("Missing number from array using Stream :" + missingNumber);

        //REVERSE EACH WORD in given string using Stream
        List<String> strList = Arrays.asList("quick brown fox jumps over lazy dog");
        String reverseStr = strList.stream().map(s -> new StringBuilder(s).reverse()).collect(Collectors.joining());
        System.out.println("Reverse each word : " + reverseStr);

        //MOVE ZEROES at end using Stream
        List<Integer> intList = Arrays.asList(34, 0, 45, 0, 62, 0, 13, 49);
        long zerosCnt = intList.stream().filter(e -> e == 0).count();
        // Traverse through stream to form a list of non zeroes, using filter and map.
        List<Integer> intListFinal = intList.stream().filter(e -> e != 0).collect(Collectors.toList());
        for (; zerosCnt > 0; zerosCnt--)
            intListFinal.add(0);
        System.out.println("\nThe Final Arraylist after moving 0's to end: ");
        System.out.println(intListFinal);

        //Find COMMON ELEMENTS using stream:
        List<Integer> list1 = Arrays.asList(1, 3, 2, 5, 4);
        List<Integer> list2 = Arrays.asList(8, 3, 2, 9, 4);
        List<Integer> findCommon = list1.stream().distinct().filter(list2::contains)
            .collect(Collectors.toList());
        System.out.println("common elements between lists :" + findCommon);

        //Find the MOST FREQUENT/REPEATED element with count
        Stream.of(1, 3, 4, 3, 4, 3, 2, 3, 3, 3, 3, 3)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(System.out::println);

        //SECOND MOST FREQUENT element using stream :
        int[] arr = {2, 1, 3, 2, 7, 2, 5, 5, 6, 2, 6};
        HashMap<Long, Integer> map = new HashMap<>();
        Arrays.stream(arr).asLongStream().forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));
        List<Integer> s = new ArrayList<>();
        map.entrySet().stream().sorted((x, y) -> x.getValue() - y.getValue()).forEach((i) -> s.add(i.getValue()));
        map.entrySet().stream().filter(x -> x.getValue() == s.get(s.size() - 2))
            .forEach(each -> System.out.println(each.getKey()));

        //SECOND-LARGEST element in Array:
        int[] values = {5, 9, 11, 2, 8, 21, 1};
        Integer secondLargestElement = Arrays.stream(values).boxed().sorted(Comparator.reverseOrder())
            .skip(1).findFirst().get();
        System.out.println("Second largest element : " + secondLargestElement);
        /**
         * Note: here in Skip(n) could be anything, for eg : if we have n=1, it means we are finding second
         * second-largest element similarly if we have n = 2, it means we find third-largest element*/

        //Second-smallest element in Array:
        int[] values1 = {5, 9, 11, 2, 8, 21, 1};
        Integer secondSmallest = Arrays.stream(values1).boxed().sorted().skip(1).findFirst().get();
        System.out.println("Second smallest element " + secondSmallest);

        //Kth smallest element :
        int k = 4;
        int[] numbs = {1, 2, 3, 3, 3, 3, 3, 3, 10, 11, 1};
        int smallest = Arrays.stream(numbs).distinct().sorted().skip(k - 1).limit(
            1).findFirst().orElse(Integer.MIN_VALUE);
        System.out.println("kth smallest " + smallest);


    }
}
