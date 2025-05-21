import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

// Lowest Common Ancestor of a Binary Tree
class LowestCommonAncestorSolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }

        if(root.val == p.val || root.val == q.val){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left!=null && right!=null){
            return root;
        }

        return left==null? right : left;
    }
}

// Maximum Width of Binary Tree
class MaximumWidthSolution {
    public void addNode(LinkedList<TreeNode> queue, TreeNode node, int val, int left) {
        if (node == null) return;
        node.val = val * 2 - left;
        queue.add(node);
    }

    public int bfs(LinkedList<TreeNode> queue) {
        int maxCount = 1;
        int size = 1;
        while (size > 0) {
            while (size-- > 0) {
                TreeNode node = queue.poll();
                addNode(queue, node.left, node.val, 1);
                addNode(queue, node.right,node.val, 0);
            }
            size = queue.size();
            if (size > 0)
                maxCount = Math.max(queue.getLast().val - queue.getFirst().val + 1, maxCount);
        }
        return maxCount;
    }

    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) return 0;
        root.val = 1;
        queue.offer(root);
        return bfs(queue);
    }
}

// All Nodes Distance K in Binary Tree
class DistanceKNodesSolution {
    List<Integer> answer = new ArrayList<>();
    Map<TreeNode, TreeNode> childParentMap = new HashMap<>();
    Set<TreeNode> visited = new HashSet<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParent(root);
        depthFirst(target, k);
        return answer;
    }
    
    private void findParent(TreeNode node) {
        if(node == null) {
            return;
        }
        if(node.left != null) {
            childParentMap.put(node.left, node);
            findParent(node.left);
        }
        if(node.right != null) {
            childParentMap.put(node.right, node);
            findParent(node.right);
        }
    }
    
    private void depthFirst(TreeNode node, int k) {
        if(node == null || visited.contains(node)) {
            return;
        }
        visited.add(node);
        if(k == 0) {
            answer.add(node.val);
            return;
        }
        depthFirst(node.left, k-1);
        depthFirst(node.right, k-1);
        depthFirst(childParentMap.get(node), k-1);
    }
}

// Count Complete Tree Nodes
class CountNodesSolution {
    public int countNodes(TreeNode root) {
        int count = 0;
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return countNodes(root.left)+countNodes(root.right)+1;
    }
}

// Construct Binary Tree from Preorder and Inorder Traversal
class BuildTreeFromPreInSolution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<inorder.length;i++)
           map.put(inorder[i],i);
        int preindex[] = {0};
        return build(preorder,map,preindex,0,inorder.length-1);
    }
    public TreeNode build(int preorder[], HashMap<Integer,Integer> map, int preindex[], int left, int right){
        if(left > right)
         return null;
         int rootVal = preorder[preindex[0]];
         preindex[0]++;
         TreeNode root = new TreeNode(rootVal);
         int index = map.get(rootVal);
         root.left = build(preorder,map,preindex,left,index-1);
         root.right = build(preorder,map,preindex,index+1,right);
         return root;
    }
}

// Construct Binary Tree from Inorder and Postorder Traversal
class BuildTreeFromInPostSolution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    
    public TreeNode build(int[] inorder, int inS, int inE, int[] postorder, int posS, int posE){
        if(inS>inE || posS>posE) return  null;
        
        TreeNode root = new TreeNode(postorder[posE]);
        
        int rootI=0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root.val){
                rootI = i;
                break;
            }
        }
        
        root.left = build(inorder,inS,rootI-1,postorder,posS,posS+rootI-inS-1);
        root.right = build(inorder,rootI+1,inE,postorder,posS+rootI-inS,posE-1);
        
        return root;
    }
}

// Serialize and Deserialize Binary Tree
public class binary_trees {
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(queue);
    }
    
    private TreeNode helper(Queue<String> queue) {
        String s = queue.poll();
        if (s.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }
}

// Binary Tree Inorder Traversal
class InorderTraversalSolution1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}

// Binary Tree Inorder Traversal (alternative implementation)
class InorderTraversalSolution2 {
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

// Flatten Binary Tree to Linked List
class FlattenBinaryTreeSolution {
    public static void travel(TreeNode root,ArrayList<TreeNode>l){
        if(root==null){
            return;
        }
        l.add(root);
        travel(root.left,l);
        travel(root.right,l);
    }
    public static void merge(TreeNode root,ArrayList<TreeNode>l){
        if(l.size()==1){
            return;
        }
        root.left=null;
        TreeNode temp=root;
        for(int i=1;i<l.size();i++){
            temp.left=null;
            temp.right=l.get(i);
            temp=temp.right;
        }
    }
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        ArrayList<TreeNode>l=new ArrayList<>();
        travel(root,l);
        merge(root,l);
    }
}