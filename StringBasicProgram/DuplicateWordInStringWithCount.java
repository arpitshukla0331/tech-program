package StringBasicProgram;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateWordInStringWithCount {
    static void printDuplicateWord(String str) {
        String[] words = str.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for(String s : words) {
            if(map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        Set<String> stringSet = map.keySet();
        for(String s : stringSet) {
            if(map.get(s) > 1) {
                System.out.println(s + " " + map.get(s));
            }
        }
    }
    public static void main(String[] args) {
        printDuplicateWord("Delhi Metro is best Metro");
    }
}
