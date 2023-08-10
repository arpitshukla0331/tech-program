package ArrayProgram;

import java.util.HashMap;

public class NthMostFrequentElement {
    public static void main(String[] args) {
        int[] a = {3,3,5,10,44,11,44,100,102,102,102};
        System.out.println(getNthMostFrequent(a));
    }
    public static int getNthMostFrequent(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxCount =0, freqValue = -1;
        for(int i =0; i<a.length; i++) {
            if(map.get(a[i])==null) {
                map.put(a[i], 1);
            }else {
                int count = map.get(a[i]) + 1;
                map.put(a[i], count);
                if(count> maxCount){
                    maxCount= count;
                    freqValue=a[i];
                }
            }
        }
        //inCase all numbers are unique
        if(freqValue== -1 && a.length>0)
            return a[0];
        return freqValue;
    }
}
