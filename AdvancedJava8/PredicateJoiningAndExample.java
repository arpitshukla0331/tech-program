package AdvanceJava8;

import java.util.function.Predicate;

public class PredicateJoiningAndExample {
    public static void testCondition(Predicate<Integer> predicate, int[] listOfNumbers) {
        for(int numbers : listOfNumbers) {
            if(predicate.test(numbers)) {
                System.out.println(numbers);
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {0,5,10,15,11,20,30};
        Predicate<Integer> predicate = i -> {
            return i >10;
        };
        Predicate<Integer> predicate1 = i -> {
            return i %2==0;
        };
        System.out.println("numbers greater than 10 and even number: ");
        testCondition(predicate.and(predicate1), numbers);

        System.out.println("numbers not greater than 10 :");
        testCondition(predicate.negate(),  numbers);
    }
}
