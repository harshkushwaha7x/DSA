import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

// Binary Tree Preorder Traversal

class PreorderTraversal {
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

class InorderTraversal {
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

class PostorderTraversal  {
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

// Binary Tree Level Order Traversal

class LevelOrderTraversal  {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>a=new ArrayList<>();
        levelorder(root,a);
        return a;
    }
    public static void levelorder(TreeNode root,List<List<Integer>>a){
        if(root==null){
            return;
        }
        List<Integer>b=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode currNode = q.remove();
            
            if (currNode == null) {
                a.add(new ArrayList<>(b));
                b.clear();
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                b.add(currNode.val);
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }
}

// Binary Tree Preorder Traversal

class PreorderTraversalAlt {
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

class InorderTraversalAlt  {
    public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res=new ArrayList<>();
    help_panunga(root,res);
    return res;
    }
    private static void help_panunga(TreeNode root,List<Integer> res){
        if(root==null)return;
        help_panunga(root.left,res);
        res.add(root.val);
        help_panunga(root.right,res);
    }
}

// Binary Tree Postorder Traversal

class PostorderTraversalAlt{
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