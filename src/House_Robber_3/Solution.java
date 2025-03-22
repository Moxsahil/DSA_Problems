package House_Robber_3;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    private int[] dfs(TreeNode node){
        if(node == null){
            return new int[] {0, 0};
        }
        int [] left = dfs(node.left);
        int [] right = dfs(node.right);

        int robbed = node.val + left[1] + right[1];
        int notRobbed = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[] {robbed, notRobbed};
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        Solution solution = new Solution();
        int result = solution.rob(root);

        System.out.println("Maximum amount that can be robbed: " + result);
    }
}
