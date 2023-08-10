package StringBasicProgram;

import java.util.ArrayList;
import java.util.List;

public class GenericMethods {
    static Character[] charArray = {'a','r','p','i','t'};
    static Integer[] intArray = {1,3,5,7,9,11};
    static Boolean[] boolArray = {true, false, true, false};

    public static <T> List<T> arrayToList(T [] array, List<T> list) {
        for(T obj : array){
            list.add(obj);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Character> charList = arrayToList(charArray, new ArrayList<>());
        List<Integer> intList = arrayToList(intArray, new ArrayList<>());
        List<Boolean> boolList = arrayToList(boolArray, new ArrayList<>());
        System.out.println(charList);
        System.out.println(intList);
        System.out.println(boolList);
    }
}
