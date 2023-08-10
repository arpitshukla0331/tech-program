package ArrayProgram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MostFrequentElementInArray {

    static void getMostFrequentElement(int inputArray[]) {
        //Creating HashMap object with elements as keys and their occurrences as values
        HashMap<Integer, Integer> elementCountMap = new HashMap<Integer, Integer>();

        //Inserting all the elements of inputArray into elementCountMap
        for (int i : inputArray) {
            if (elementCountMap.containsKey(i)) {
                //If an element is present, incrementing its count by 1
                elementCountMap.put(i, elementCountMap.get(i) + 1);
            } else {
                //If an element is not present, put that element with 1 as its value
                elementCountMap.put(i, 1);
            }
        }

        int element = 0;
        int frequency = 1;

        //Iterating through elementCountMap to get the most frequent element and its frequency
        Set<Map.Entry<Integer, Integer>> entrySet = elementCountMap.entrySet();

        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() > frequency) {
                element = entry.getKey();

                frequency = entry.getValue();
            }
        }

        //Printing the most frequent element in array and its frequency

        if (frequency > 1) {
            System.out.println("Input Array : " + Arrays.toString(inputArray));

            System.out.println("The most frequent element : " + element);

            System.out.println("Its frequency : " + frequency);

            System.out.println("========================");
        } else {
            System.out.println("Input Array : " + Arrays.toString(inputArray));
        }
    }

    public static void main(String[] args) {
        getMostFrequentElement(new int[]{4, 5, 8, 7, 4, 7, 6, 7});
    }
}

