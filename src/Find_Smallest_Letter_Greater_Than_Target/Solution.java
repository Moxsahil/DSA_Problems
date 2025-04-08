package Find_Smallest_Letter_Greater_Than_Target;

public class Solution {
    public char nextGreatestLetter(char[] letters, char target){
        int left = 0;
        int right = letters.length;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(letters[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return letters[left % letters.length];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
    }
}
