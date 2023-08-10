package StringBasicProgram;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumberUsingStream {

   static List<Integer> primeNumber(int n) {
       return IntStream.rangeClosed(2,n).filter(x-> isPrime(x))
               .boxed().collect(Collectors.toList());
   }

   static boolean isPrime(int numbers) {
       return numbers>1 && IntStream.range(2, numbers).noneMatch(i-> numbers%2==0);
   }

    public static void main(String[] args) {
        System.out.println("Prime numbers: " + primeNumber(20));
    }
}
