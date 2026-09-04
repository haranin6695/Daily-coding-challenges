problem:319
problem name:bulb switcher logic
category:medium
class Solution {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}


problem:617
problem name:merge two binary trees
category:easy
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    
        return merge(root1, root2);
    }
    private TreeNode merge(TreeNode r1, TreeNode r2){
        if(r1 == null) return r2;
        if(r2 == null) return r1;

        r1.val = r1.val + r2.val;

        r1.left = merge(r1.left, r2.left);
        r1.right = merge(r1.right, r2.right);

        return r1;
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
