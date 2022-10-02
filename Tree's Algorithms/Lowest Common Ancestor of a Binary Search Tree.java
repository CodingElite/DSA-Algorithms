// Lowest Common Ancestor of a Binary Search Tree

// In BST three condition : 1) if root.val< p.val and root.val<q.val => move to right
//                          2) else if root.val> p.val and root.val> q.val => move to left
//                          3) else return root

// Time Complexity - O(h)
// Space Complexity - O(1)


// Approach 1: recursion

// Code:

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null)    return null;

        int curr = root.val;

        if(curr < p.val && curr < q.val)    return lowestCommonAncestor(root.right , p , q);
        if(curr > p.val && curr > q.val)    return lowestCommonAncestor(root.left ,  p , q);

        return root;
    }
}

//Approach 2 : Iterative Solution

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null)    return null;

        while(root!=null){
            int val = root.val;
            if(val < p.val && val < q.val)  root = root.right;
            else if(val > p.val && val > q.val) root = root.left;
            else return root;
        }
        return null;
    }
}
