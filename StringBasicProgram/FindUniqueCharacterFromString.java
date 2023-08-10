package StringBasicProgram;

import java.util.HashMap;
import java.util.Map;

public class FindUniqueCharacterFromString {
    //Complexity : O(n)

    public static void main(String[] args) {
        String str = "hello";
        StringBuilder  stringBuilder = new StringBuilder();
        Map<Character, Character> map = new HashMap<>();
        for(char c : str.toCharArray()) {
            map.put(c,c);
        }
        map.values().forEach(stringBuilder::append);
        System.out.println("unique character :" + stringBuilder);
    }
}
