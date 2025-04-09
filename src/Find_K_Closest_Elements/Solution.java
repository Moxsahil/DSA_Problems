package Find_K_Closest_Elements;

import java.util.ArrayList;
import java.util.List;

/*
    -> we have to find the closest element around a given value for 'x' and no of element told by 'k' inside a given array
    -> To solve this problem we can follow the approach Binary Search + Two Pointer which is best optimal solution
    -> intialize two pointers left and right at 0th index and the arr.length - k respectively
    -> Find the mid value inside the array
    -> if the value of ( x - arr[mid] > arr[mid + k] - x) satisfied then move the left pointer to mid + 1 otherwise move right pointer to mid
    -> Initialize a List using ArrayList to store the value
    -> Traverse from left pointer to left + k
    -> add the value inside list
    -> return the list
    -----> Time Complexity = O(log(n - k) + k)
    -> Log(n - k) for binary search
    -> k for collecting the final result

    -----> Space Complexity = O(k) for the ans List
*/
public class Solution {

        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int left = 0;
            int right = arr.length - k;

            while(left < right){
                int mid = left + (right - left) / 2;
                if( x - arr[mid] > arr[mid + k] - x){
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            List<Integer> ans = new ArrayList<>();
            for(int i = left; i < left + k; i++){
                ans.add(arr[i]);
            }
            return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int k = 4;
        int x = 3;

        Solution sol = new Solution();

        System.out.print("The closet element around the given x is : " + sol.findClosestElements(arr, k, x));
    }
}
