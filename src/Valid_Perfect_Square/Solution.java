package Valid_Perfect_Square;
/*
 -> Given a positive integer num, return true if num is a perfect square or false otherwise.
    A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.
    You must not use any built-in library function, such as sqrt.
*/
public class Solution {
    public boolean isPerfectSquare(int num){
        if(num < 2){
            return true;
        }

        long left = 1;
        long right = num;

        while(left <= right){
            long mid = left + (right - left)/2;

            long square = mid * mid;

            if(square == num) return true;
            else if (square < num) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
    public static void main(String[] args) {
        int num = 17;

        Solution sol = new Solution();
        boolean result = sol.isPerfectSquare(num);
        if(result){
            System.out.println("Yes, It is a perfect square");
        } else {
            System.out.println("No, It is not a perfect square");
        }
    }
}
