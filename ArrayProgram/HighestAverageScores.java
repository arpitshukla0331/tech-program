package ArrayProgram;

import java.util.HashMap;

public class HighestAverageScores {
    public static void main(String[] args) {
        String[][] scores = {{"jerry", "5"}, {"bob", "5"}, {"jerry", "63"},
                              {"John", "12"}, {"Eric", "6"}, {"jerry", "11"}};

        HashMap<String, Integer> scoreMap = new HashMap<>();
        HashMap<String, Integer> countMap = new HashMap<>();

        for (String[] entry : scores) {
            String name = entry[0];
            int score = Integer.parseInt(entry[1]);

            scoreMap.put(name, scoreMap.getOrDefault(name, 0) + score);
            countMap.put(name, countMap.getOrDefault(name, 0) + 1);
        }

        double highestAverage = 0;
        String highestAverageName = "";

        for (String name : scoreMap.keySet()) {
            int totalScore = scoreMap.get(name);
            int count = countMap.get(name);
            double average = (double) totalScore / count;

            if (average > highestAverage) {
                highestAverage = average;
                highestAverageName = name;
            }
        }

        System.out.println("Name with the highest average score: " + highestAverageName);
        System.out.println("Highest average score: " + highestAverage);

    }
}
