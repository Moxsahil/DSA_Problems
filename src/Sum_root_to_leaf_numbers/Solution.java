package Sum_root_to_leaf_numbers;

/*
root = [1,2,3]
return the sum from all root to leaf node
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val ,TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {
    public static int sumNumbers(TreeNode root){
        return dfs(root, 0);
    }
    private static int dfs(TreeNode node , int currentSum){
        if(node == null){
            return 0;
        }
        currentSum = currentSum * 10 + node.val;
        if(node.left == null && node.right == null){
            return currentSum;
        }
        int leftSum = dfs(node.left, currentSum);
        int rightSum = dfs(node.right, currentSum);
        return leftSum + rightSum;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Solution sol  = new Solution();

        int result = sol.sumNumbers(root);

        System.out.println("The sum of all node root to nodes :  " + result);
    }
}
