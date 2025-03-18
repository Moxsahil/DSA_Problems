package Maximum_Product_Subarray;

public class Solution {
    public static int maxProduct(int [] nums ){
        if(nums.length == 0){
            return 0;
        }

        int result = nums[0];
        int maxProduct = nums[0];
        int minProduct = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }
            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);

            result = Math.max(result, maxProduct);
        }
        return result;
    }
    public static void main(String[] args) {
        int []  nums = {2, 5, -2, 4};

        Solution sol = new Solution();
        int result = sol.maxProduct(nums);
        System.out.println("Maximum product subarray : " + result);
    }
}
