// Maximum Depth of Binary Tree

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}

// Balanced Binary Tree

class Solution {
    public int height(TreeNode root){
        if(root == null) return 0;

        int leftht = height(root.left);
        int rightht = height(root.right);

        if(leftht == -1 || rightht == -1) return -1;

        if(Math.abs(leftht - rightht) > 1) return -1; 

        return Math.max(leftht,rightht) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
}

