package Lowest_Common_Ancestor_of_Deepest_Leaves;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
public class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
    return dfs(root).node;
}

    private class Result {
        TreeNode node;
        int depth;

        Result(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    private Result dfs(TreeNode node) {
        if (node == null) return new Result(null, 0);

        Result left = dfs(node.left);
        Result right = dfs(node.right);

        if (left.depth > right.depth) {
            return new Result(left.node, left.depth + 1);
        } else if (right.depth > left.depth) {
            return new Result(right.node, right.depth + 1);
        } else {
            return new Result(node, left.depth + 1);
        }
    }
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2, node7, node4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, node6, node2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node1 = new TreeNode(1, node0, node8);
        TreeNode root = new TreeNode(3, node5, node1);

        Solution sol = new Solution();
        TreeNode lca = sol.lcaDeepestLeaves(root);
        System.out.println("LCA of deepest leaves: " + (lca != null ? lca.val : "null"));
    }
}
