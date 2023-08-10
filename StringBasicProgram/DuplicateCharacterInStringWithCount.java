package StringBasicProgram;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateCharacterInStringWithCount {
    public static void printDuplicate(String str) {
        char[] characters = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : characters) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        System.out.printf("List of duplicate characters in String '%s' %n", str);
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() > 1)
                System.out.printf("%s : %d %n", entry.getKey(), entry.getValue());
        }
    }
    public static void main(String[] args) {
        printDuplicate("Java");
        printDuplicate("Machine Learning");
        printDuplicate("AADBBCQQR");
    }
}
