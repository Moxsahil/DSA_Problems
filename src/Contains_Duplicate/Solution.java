package Contains_Duplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsDuplicate(int[] nums , int k){
        Set<Integer> window = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(window.contains(nums[i])){
                return true;
            }
            window.add(nums[i]);
            if(window.size() > k){
                window.remove(nums[i - k]);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int [] nums = {1, 2, 3, 1};
        int k = 3;
        Solution sol = new Solution();

        boolean result = sol.containsDuplicate(nums, k);

        if(result){
            System.out.print("The array you provided has contains duplicate values.");
        } else {
            System.out.print("The array you provided doesn't have contains any duplicate values.");
        }
    }
}
