package Majority_Element;

public class Solution {
    public int majority(int [] nums){
        int candidate = 0;
        int count = 0;

        for(int num : nums){
            if(count == 0){
                candidate = num;
            }
            if(num == candidate){
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
    public static void main(String[] args) {
        int []  nums = {3,2,3,1,2,4,2,2};
        Solution sol = new Solution();

        System.out.println("The majority element is : " + sol.majority(nums));
    }
}
