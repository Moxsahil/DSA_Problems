package Remove_Element;

public class Solution {
    public int removeElement(int [] nums , int value){
        int i = 0;
        for(int j=0; j<nums.length; j++){
            if(nums[j] != value){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        int [] nums = {3,2,2,3};
        int value = 3;

        int result = sol.removeElement(nums, value);

        System.out.println(result);
    }
}
