package Creating_a_BinaryTree_from_PreOrder_and_InOrder;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

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
    private int preOrderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder){
        inorderMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        preOrderIndex = 0;
        return buildTreeHelperMethod(preorder, 0, inorder.length-1);
    }
    public TreeNode buildTreeHelperMethod(int [] preorder, int left, int right){
        if(left > right){
            return null;
        }
        int rootValue = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(rootValue);

        System.out.println("Creating Node : " + rootValue);
        System.out.println("Inorder Position of " + rootValue + " : " + inorderMap.get(rootValue));
        root.left = buildTreeHelperMethod(preorder, left, inorderMap.get(rootValue) - 1);
        root.right = buildTreeHelperMethod(preorder, inorderMap.get(rootValue) + 1, right);
        return root;
    }
    public static void main(String[] args) {
        int [] preorder = {3, 9, 20, 15, 7};
        int [] inorder = {9, 3, 15, 20, 7};

        Solution sol = new Solution();

        System.out.println("Building Tree : ");
        TreeNode root = sol.buildTree(preorder, inorder);

        System.out.println("\nLevel Order Traversal of constructed tree : ");

        sol.printTree(root);
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
