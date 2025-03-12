package Binary_Tree_Maximum_Path_Sum;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
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

    private int maxSum = Integer.MIN_VALUE;
    public  int maxPathSum(TreeNode root){
        dfs(root);
        return maxSum;
    }
    private int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftMax = Math.max(dfs(node.left), 0);
        int rightMax = Math.max(dfs(node.right), 0);

        int currentPathSum = node.val + leftMax + rightMax;

        maxSum = Math.max(maxSum, currentPathSum);
        return node.val + Math.max(leftMax, rightMax);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Solution sol = new Solution();

        int result = sol.maxPathSum(root);
        System.out.println("Total sum : "+ result);
    }
}
