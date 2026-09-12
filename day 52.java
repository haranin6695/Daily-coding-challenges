program:563
program name:binary tree tilt
category:easy
  class Solution {
    private int total = 0;

    public int findTilt(TreeNode root) {
        sum(root);

        return total;
    }

    private int sum(TreeNode root){
        if(root == null) return 0;

        int left = sum(root.left);
        int right = sum(root.right);

        total += Math.abs(left - right);

        return root.val + left + right;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


program:783
program name:minimum distance between bst nodes
category:easy
  class Solution {
    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public int minDiffInBST(TreeNode root) {
        helper(root);
        return min;
    }
    private void helper(TreeNode root){
        if(root == null) return;

        helper(root.left);

        if(prev != null){
            min = Math.min(min, Math.abs(prev - root.val));
        }
        prev = root.val;

        helper(root.right);
    }
}
