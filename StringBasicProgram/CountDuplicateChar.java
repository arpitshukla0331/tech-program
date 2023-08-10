package StringBasicProgram;

        import java.util.HashMap;
        import java.util.Map;

public class CountDuplicateChar {
    public static void charCountInString(String name) {
        Map<Character, Integer> map = new HashMap<>();
        char strArray[] = name.toCharArray();
        for(char c : strArray) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c,1);
            }
        }
        System.out.println("frequency of each character: " + map);
    }
    public static void main(String[] args) {
        charCountInString("JavaJavaEE");
    }
}
