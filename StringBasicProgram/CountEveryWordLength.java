package StringBasicProgram;

import java.util.*;
import java.util.stream.Collectors;

public class CountEveryWordLength {
    public static void main(String[] args) {
        String[] wordsStr = {"hello", "apple", "is", "sweet", "programming is", "cool"};
        List<String> stringList = new ArrayList<>(Arrays.asList(wordsStr));

        Map<Integer, List<String>> map =
                stringList.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("CountEveryWordLength :" + map);
    }
}
