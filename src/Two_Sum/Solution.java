package Two_Sum;

import java.util.*;

public class Solution {
    public int [] twoSum(int [] nums, int target){

        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.isEmpty() || !map.containsKey(target - nums[i])){
                map.put(nums[i], i);
            } else if(map.containsKey(target-nums[i])){
                return new int []{map.get(target - nums[i]), i};
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int [] nums = {2, 7, 11, 15};
        int target = 9;

        Solution sol = new Solution();

        int[] result = sol.twoSum(nums, target);

        if(result != null){
            System.out.println("Indices are " +result[0] +" , " + result[1]);
        }  else {
            System.out.println("not found");
        }
    }
}
