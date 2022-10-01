// Preorder Traversal 
// Input: root = [1,null,2,3]
// Output: [1,2,3]

// Problem LeetCode : https://leetcode.com/problems/binary-tree-preorder-traversal/

// Approach 1: Recusrsive
// Inorder-> Root Left Right

// Time Complexity - O(n)
// Space Complexity - O(n)

// Code:

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
    
    public void preOrder(TreeNode root , List<Integer> ans){
    
        if(root==null)  return;
        
        ans.add(root.val);
        preOrder(root.left , ans);
        preOrder(root.right , ans);
        
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        
        preOrder(root , ans);
        
        return ans;
        
    }
}

// Approach 2: Iterative
// Inorder-> Left Root Right

// Use stack 

// Time Complexity - O(n)
// Space Complexity - O(n)

// Code:

/*
	
	Following is the Binary Tree node structure:
	public class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.data = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	       this.data = val;
	        this.left = left;
	        this.right = right;
	    }
	}
*/
import java.util.*;
public class Solution {
    public static List < Integer > getPreOrderTraversal(TreeNode root) {
    	// Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root==null)    return ans;
        st.push(root);
        
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            ans.add(node.data);
            if(node.right!=null)    st.push(node.right);
            if(node.left!=null)    st.push(node.left);
            
        }
        
        return ans;
    }
}
