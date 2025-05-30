// Insert into a Binary Search Tree

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
                if(root == null) return new TreeNode(val);
               if(val > root.val) root.right = insertIntoBST(root.right, val);
                if(val < root.val) root.left = insertIntoBST(root.left, val);
              return root;
    }
}

// Delete Node in a BST

class Solution{
    public int mVa(TreeNode root){
        int mV=root.val;
        while(root.left!=null){
            mV=root.left.val;
            root=root.left;
        }
        return mV;
    }
    public TreeNode deleteNode(TreeNode root,int key){
        if (root==null){
            return null; 
        }
        if (key<root.val){
            root.left=deleteNode(root.left,key);
        }
        else if (key>root.val){
            root.right=deleteNode(root.right,key);
        }
        else {
            if (root.left==null){
                return root.right;
            } 
            else if (root.right==null){
                return root.left;
            }
            root.val=mVa(root.right);
            root.right=deleteNode(root.right, root.val);
            }
        return root;
    }
}

// Kth Smallest Element in a BST

class Solution {
    int count;
    int value;
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        inorderTraversal(root, k);
        return value;
    }

    private void inorderTraversal(TreeNode root, int k) {
        if(root == null) {
            return;
        }
        inorderTraversal(root.left, k);
        count++;
        if(count == k) {
            value = root.val;
        }
        inorderTraversal(root.right, k);
    }
}

// Validate Binary Search Tree

class Solution {
    static boolean flag = true;
    static TreeNode prev = null;
    public void inorder(TreeNode root) {
        if(root==null) return;
        inorder(root.left);
        if(prev==null) prev = root;
        else if(root.val<=prev.val){
            flag = false;
        }
        else prev = root;
        inorder(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        flag = true;
        prev = null;
        inorder(root);
        return flag;
    }
}

// Lowest Common Ancestor of a Binary Search Tree

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        int curr = root.val;
        
        if (curr < p.val && curr < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (curr > p.val && curr > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}

// Construct Binary Search Tree from Preorder Traversal

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            if (preorder[i] < stack.peek().val) {                
                stack.peek().left = node;                
            } else {
                TreeNode parent = stack.peek();
                while (!stack.isEmpty() && preorder[i] > stack.peek().val) {
                    parent = stack.pop();
                }
                parent.right = node;
            }
            stack.push(node);            
        }
        return root;
    }
}