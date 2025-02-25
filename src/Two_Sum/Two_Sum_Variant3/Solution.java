package Two_Sum.Two_Sum_Variant3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static int[] twoSum(int[] numbers, int target){
        int left = 0;
        int right = numbers.length - 1;

        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
               return new int []{left + 1, right + 1};
            } else if(sum < target){
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }
    public static void main(String[] args) {
//        int [] numbers = {2,7, 11, 15};
//        int target = 9;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no elements you want to use : ");
        int n = sc.nextInt();

        int [] numbers = new int[n];
        System.out.print("Enter the elements : ");
        for(int i=0; i<n; i++){
            numbers[i] = sc.nextInt();
            System.out.print(",");
        }

        System.out.print("Enter the Target value to check : ");
        int target = sc.nextInt();
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }
}
