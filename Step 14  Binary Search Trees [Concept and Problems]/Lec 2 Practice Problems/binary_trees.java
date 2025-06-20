// Insert into a Binary Search Tree

class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(val > root.val) root.right = insertIntoBST(root.right, val);
        if(val < root.val) root.left = insertIntoBST(root.left, val);
        return root;
    }
}

// Delete Node in a BST

class DeleteNodeInBST {
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

class KthSmallestElementInBST {
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

class ValidateBinarySearchTree {
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

class LowestCommonAncestorOfBST {
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

class ConstructBSTFromPreorder {
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

// Binary Search Tree Iterator

class BSTIterator {
    private Stack<TreeNode> st = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode tempNode = st.pop();
        pushAll(tempNode.right);
        return tempNode.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void pushAll(TreeNode node) {
        while(node != null) {
            st.push(node);
            node = node.left;
        }
    }
}

// Two Sum IV - Input is a BST

class TwoSumIV {
    public boolean findTarget(TreeNode root, int k){
        HashSet<Integer> set=new HashSet<>();
        return dfs(root,set,k);
    }
    private boolean dfs(TreeNode node, HashSet<Integer> set, int k){
        if(node==null){
            return false;
        }
        if(set.contains(k-node.val)){
            return true;
        }
        set.add(node.val);
        return dfs(node.left, set, k) || dfs(node.right, set, k);
    }
}

// Recover Binary Search Tree

class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;

        TreeNode current = root;
        while(current!=null){
            if(current.left == null){
                if(prev!=null && prev.val>current.val){
                    if(first == null){
                        first = prev;
                        second = current;
                    }else{
                        second = current;
                    }
                }
                prev=current;
                current = current.right;
            }else{
                TreeNode predecessor = current.left;
                while(predecessor.right!=null && predecessor.right!=current){
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null){
                    predecessor.right = current;
                    current = current.left;
                }else{
                    predecessor.right = null;
                    if(prev != null && prev.val>current.val){
                        if(first == null){
                            first = prev;
                            second = current;
                        }else{
                            second = current;
                        }
                    }
                    prev = current;
                    current = current.right;
                }
            }
        }
        if(first!=null && second!=null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}