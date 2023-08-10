package AdvanceJava8;


import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        Predicate<Integer> integerPredicate = i -> (i>100);
        System.out.println(integerPredicate.test(10));
        System.out.println(integerPredicate.test(101));
        System.out.println(integerPredicate.test(100));

        //chaining the Predicate:
        Predicate<String> stringPredicate = str-> (str.length()>3);
        System.out.println(stringPredicate.test("john"));
        System.out.println(stringPredicate.test("arp"));

        int num = 5;
        long factorial = 1;
        for(int i = 1; i <= num; ++i)
        {
            // factorial = factorial * i;
            factorial *= i;
        }
        System.out.printf("Factorial of %d = %d", num, factorial);
    }

    }

