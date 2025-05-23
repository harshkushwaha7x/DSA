import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Map;

// Maximum Depth of Binary Tree

class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}

// Balanced Binary Tree

class BalancedBinaryTree {
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

class DiameterOfBinaryTree {
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

// Binary Tree Maximum Path Sum

class BinaryTreeMaximumPathSum {
    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxsum(root);
        return res;
    }

    private int maxsum(TreeNode root) {
        if (root == null) return 0;

       int ls=maxsum(root.left);
       int rs=maxsum(root.right);

        int temp = Math.max(Math.max(ls,rs)+root.val,root.val);
        int max = Math.max(temp, ls + rs + root.val);

        res = Math.max(res, max);
        return temp;
    }
}

// Same Tree

class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

// Binary Tree Zigzag Level Order Traversal

class binary_trees {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> sol = new ArrayList<>();
        travel(root, sol, 0);
        return sol;
    }
    
    private void travel(TreeNode curr, List<List<Integer>> sol, int level)
    {
        if(curr == null) return;
        
        if(sol.size() <= level)
        {
            List<Integer> newLevel = new LinkedList<>();
            sol.add(newLevel);
        }
        
        List<Integer> collection  = sol.get(level);
        if(level % 2 == 0) collection.add(curr.val);
        else collection.add(0, curr.val);
        
        travel(curr.left, sol, level + 1);
        travel(curr.right, sol, level + 1);
    }
}

// Vertical Order Traversal of a Binary Tree

class VerticalOrderTraversalOfBinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        TreeMap<Integer,List<int[]>> tm=new TreeMap<>();
        dfs(root,0,0,tm);
        for(Map.Entry<Integer,List<int[]>> e:tm.entrySet()){
            List<int[]> nodes=e.getValue();
            nodes.sort((a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
            List<Integer> temp=new ArrayList<>();
            for(int[] p:nodes) temp.add(p[1]);
            res.add(temp);
        }
        return res;
    }
    void dfs(TreeNode node,int r,int c, TreeMap<Integer,List<int[]>> tm){
        if(node==null) return;
        tm.putIfAbsent(c,new ArrayList<>());
        tm.get(c).add(new int[]{r,node.val});
        dfs(node.left,r+1,c-1,tm);
        dfs(node.right,r+1,c+1,tm);
    }
}

// Binary Tree Right Side View

class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()){
            TreeNode right = null;
            int n = queue.size();
            for (int i = 0; i < n; i++){
                TreeNode curr = queue.poll();
                if (curr != null){
                    right = curr;
                    queue.offer(curr.left);
                    queue.offer(curr.right);
                }
            }
            if (right != null){
                list.add(right.val);
            }
        }
        return list;
    }
}

// Symmetric Tree

class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return solve(root.left , root.right);
    }
    public boolean solve(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val!=root2.val) return false;
        return solve(root1.left, root2.right) && solve(root1.right, root2.left); 
    }
}