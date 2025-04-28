import java.util.ArrayList;
import java.util.List;

// Binary Tree Preorder Traversal

class Solution {
    public List<Integer> Traversal(TreeNode root,List<Integer> arr){
        if(root!=null){
            int data=root.val;
        arr.add(data);
            Traversal(root.left,arr);
            Traversal(root.right,arr);
        }
        return arr;
    } 
    
    public List<Integer> preorderTraversal(TreeNode root) {
    ArrayList<Integer>arr=new ArrayList<>();
    return Traversal(root,arr);
    }
}

// Binary Tree Inorder Traversal

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
    }
}

// Binary Tree Postorder Traversal

class Solution {
    private void find(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        find(root.left, ans);
        find(root.right, ans);
        ans.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        find(root, ans);
        return ans;
    }
}

