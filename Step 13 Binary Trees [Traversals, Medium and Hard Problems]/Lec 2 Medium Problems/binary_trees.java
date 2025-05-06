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

// Diameter of Binary Tree

class Solution {
    public static int height(TreeNode root) {
    if (root == null)
        return 0;
    if (root.left == null && root.right == null)
        return 0;
    return 1 + Math.max(height(root.left), height(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
        return 0;
        if (root.left == null && root.right == null)
        return 0;
        int leftAns = diameterOfBinaryTree(root.left);
        int rightAns = diameterOfBinaryTree(root.right);
        int midAns = height(root.left) + height(root.right);
        if(root.left!=null) midAns++;
        if(root.right!=null) midAns++;
        int max = Math.max(leftAns,Math.max(rightAns,midAns));
        return max;

    }
}

