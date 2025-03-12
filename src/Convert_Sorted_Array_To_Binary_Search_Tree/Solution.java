package Convert_Sorted_Array_To_Binary_Search_Tree;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;
    TreeNode(TreeNode next){
        this.next = next;
    }
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {
    public static TreeNode sortedArrayToBST(int[] nums){
        if(nums.length == 0 || nums == null){
            return null;
        }
        return buildBST(nums, 0 , nums.length -1);
    }
    private static TreeNode buildBST(int [] nums, int left, int right){
        if(left > right){
            return null;
        }
        int mid = left + (right - left)/2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBST(nums, left , mid -1);
        node.right = buildBST(nums, mid + 1, right);
        return node;
    }
    public static void main(String[] args) {
        int [] nums = {-10, -3, 0, 5, 9};

        Solution sol = new Solution();

        TreeNode result = sol.sortedArrayToBST(nums);
        printTree(result);
    }
    public static void printTree(TreeNode node){
        if(node == null){
            return;
        }
        while(node != null){
            printTree(node.left);
            System.out.print(node.val + " ");
            printTree(node.right);
            node = node.next;
            }
    }
}
