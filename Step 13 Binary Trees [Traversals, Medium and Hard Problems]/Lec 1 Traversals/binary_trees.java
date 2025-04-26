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