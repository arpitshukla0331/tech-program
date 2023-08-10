package StringBasicProgram;

import java.util.*;
import java.util.stream.Collectors;

public class FindUniqueWordInString {
    public static void main(String[] args) {
        String str = "India Germany England Japan India USA Japan";
        Map<String, Long> map = Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(s -> s, HashMap::new, Collectors.counting()));
        map.forEach((k,v) -> {
            if(v == 1 ){
                System.out.println(k + ", " +v);
            }
        });
    }
}
