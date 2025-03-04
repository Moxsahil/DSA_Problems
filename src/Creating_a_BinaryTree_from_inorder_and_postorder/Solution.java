package Creating_a_BinaryTree_from_inorder_and_postorder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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

    private Map<Integer, Integer> inorderMap;
    private int postorderIndex;

    public TreeNode buildTree(int [] postorder, int [] inorder){
        inorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        postorderIndex = postorder.length - 1;
        return buildTreeHelper(postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int [] postorder, int left, int right){
        if(left > right){
            return null;
        }
        int rootVal = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootVal);

        int index = inorderMap.get(rootVal);

        root.right = buildTreeHelper(postorder, index + 1, right);
        root.left = buildTreeHelper(postorder, left , index-1);

        return root;
    }
    public static void main(String[] args) {
        int [] inorder =  {9, 3, 15, 20, 7};
        int [] postorder = {9, 15, 7, 20, 3};

        Solution sol = new Solution();

        TreeNode root = sol.buildTree(postorder, inorder);

        printTree(root);
    }
    public static void printTree(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
           TreeNode node = queue.poll();
            if(node != null){
                System.out.print(node.val + " ");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                System.out.print(" null ");
            }
        }
    }
}
