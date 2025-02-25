package Count_Integer_With_even_Digiit_Sum;

public class Solution {
    public static int countEven(int num) {
        int count = 0;

        for (int i = 1; i <= num; i++) {
            if (digitSum(i) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private static int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int num = 30;
        System.out.println("No of +ve Integer are : " + countEven(num));
    }
}
