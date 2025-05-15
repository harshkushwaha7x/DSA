// Lowest Common Ancestor of a Binary Tree

class Solution {
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

class Solution {
    public void addNode(LinkedList<TreeNode> queue, TreeNode node, int val, int left)
    {
        if (node == null) return;
        node.val = val * 2 - left;
        queue.add(node);
    }

    public int bfs(LinkedList<TreeNode> queue)
    {
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

class Solution {
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

class Solution {
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

