package Path_Sum;

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
    public static boolean pathSum(TreeNode root , int target){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null && target == root.val){
            return true;
        }

        boolean leftPath = pathSum(root.left, target - root.val);
        boolean rightPath = pathSum(root.right, target - root.val);

        return leftPath || rightPath;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        int target = 22;

        Solution sol = new Solution();

        boolean result = sol.pathSum(root, target);

        if(result){
            System.out.println("Yes, the Path Sum is equals to your provided target value");
        } else {
            System.out.println("No, the Path Sum is not equals to your provided target value");
        }
    }
}

