package Count_Equal_and_Divisible_Pairs_in_an_Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int countPairs(int[] nums, int k) {
        int count = 0;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i< nums.length; i++){
            map.computeIfAbsent(nums[i], v -> new ArrayList<>()).add(i);
        }

        for(List<Integer> indices : map.values()){
            int size = indices.size();
            for(int i = 0; i < size; i++){
                for(int j = i + 1; j < size; j++){
                    int index1 = indices.get(i);
                    int index2 = indices.get(j);
                    if((index1 * index2) % k == 0){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
       int[] nums = {3, 1, 2, 2, 2, 1, 3};
       int k = 2;
       Solution sol = new Solution();

       System.out.print("The number of pairs that satisfies the required conditions : " + sol.countPairs(nums, k));
    }
}
