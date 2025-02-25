package Number_Of_SubArrays_With_Odd_Sum;

public class Solution {
    public static int subArray(int [] arr){
        int result = 0;

        int oddCount = 0;
        int evenCount = 1;

        final int MOD = 1_000_000_007;
        int prefixSum = 0;

        for(int num : arr){
            prefixSum += num;

            if(prefixSum % 2 == 0){
                result = (result + oddCount) % MOD;
                evenCount++;
            } else {
                result = (result + evenCount) % MOD;
                oddCount++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int [] arr = {1,3,5,7};

        System.out.println("Total no of pair which generates odd sum : " + subArray(arr));
    }
}
