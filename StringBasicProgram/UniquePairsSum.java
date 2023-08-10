package StringBasicProgram;

import java.util.HashSet;
import java.util.Set;

public class UniquePairsSum {
    //Complexity : O(n)
    public static int uniquePairsSum(int[] number, int picked){
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> seen = new HashSet<Integer>();
        int count = 0;
        for(int i : number){
            if(set.contains(picked-i) && !seen.contains(i)){
                count++;
                seen.add(picked-i);
                seen.add(i);
            }
            else if(!set.contains(i)){
                set.add(i);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] number = {1, 1, 2, 45, 46, 46};
        int picked = 47;
        System.out.println(uniquePairsSum(number, picked));
    }
}
//-------------Using MAP ------------------------------------
   /* public static int getUniquePairsOpti(int[] nums, int target){
        Set<Integer> seen =  new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums){
            if (map.containsKey(num)){
                int key = map.get(num)*10 + num;
                if (! seen.contains(key)){
                    ans++;
                    seen.add(key);
                }
            } else {
                map.put(target-num, num);
            }
        }
        return ans;

    }*/
