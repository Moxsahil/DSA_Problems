package Remove_Duplicates_From_Sorted_Array;

public class Solution {

    public int removeDuplicates(int [] nums){
        if(nums.length == 0){
            return 0;
        }
        int i = 0;
        for(int j = 1; j < nums.length; j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
    public static void main(String[] args) {

        Solution sol = new Solution();
        int [] nums = {1, 1, 2};

       int result =  sol.removeDuplicates(nums);

        System.out.println(result);
    }
}
