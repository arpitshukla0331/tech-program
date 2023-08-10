package StringBasicProgram;

import java.util.HashMap;
import java.util.Map;

public class ShortestUniqueSubstringLength {
    public static int solution(String S) {
        int length = S.length();
        Map<String, Integer> substringCount = new HashMap<>();

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                String substring = S.substring(i, j);
                substringCount.put(substring, substringCount.getOrDefault(substring, 0) + 1);
            }
        }
        int shortestLength = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> entry : substringCount.entrySet()) {
            if (entry.getValue() == 1) {
                shortestLength = Math.min(shortestLength, entry.getKey().length());
            }
        }
        return shortestLength;
    }

    public static void main(String[] args) {
        String S = "zyzyzyz";
        int shortestLength = solution(S);
        System.out.println("Shortest unique substring length: " + shortestLength);
    }
}

