problem:872
problem name:Leaf-Similar Trees
category:easy
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
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        helper(list1, root1);
        helper(list2, root2);

        if(list1.equals(list2))
            return true;
        else
            return false;        
    }
    private void helper(List<Integer>list , TreeNode root)
    {
        if(root == null)
            return;
        if(root.left == null && root.right==null)
        {
            list.add(root.val);
            return;
        }
        else
        {
            helper(list, root.left);
            helper(list, root.right);
        }
    }
}




problem:876
problem name:Middle of the Linked List
category:easy
  class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null)
            return null;

        ListNode temp = head;
        int cnt = 0;

        // Count the number of nodes
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        // Find the position of the middle node
        cnt = (cnt / 2) + 1;

        // Move to the middle node
        temp = head;
        while (--cnt > 0) {
            temp = temp.next;
        }

        return temp;
    }
}
