// Maximum XOR of Two Numbers in an Array
class Node{
    Node[] links = new Node[2];
    Node(){}
    public boolean containsKey(int bit){
        return links[bit]!=null;
    }
    public void put(int bit,Node node){
        links[bit]=node;
    }
    public Node get(int bit){
        return links[bit];
    }
}
public class Trie{

    private static Node root;

    public Trie(){
        root = new Node();
    }

    public static  void insert(int num){
        Node node = root;
        for(int i=31;i>=0;i--){
            int bit = ((num>>i) & 1);
            if(!node.containsKey(bit)){
                node.put(bit,new Node());
            }
            node = node.get(bit);
        }
    }

    public  static int find_max(int num){
        int maxi=0;
        Node node = root;
        for(int i=31;i>=0;i--){
            int bit = ((num>>i) & 1);
            if(node.containsKey(1-bit)){
                maxi = (maxi | (1<<i));
                node = node.get(1-bit);
            }
            else{
                node = node.get(bit);
            }
        }
        return maxi;
    }
}
class Solution {
    public int findMaximumXOR(int[] nums) {

        Trie trie = new Trie();
        for(int i=0;i<nums.length;i++){
            trie.insert(nums[i]);
        }

        int answer=0;
        for(int i=0;i<nums.length;i++){

            answer = Math.max(answer,trie.find_max(nums[i]));
        }

        return answer;
        
    }
}

// Maximum XOR With an Element From Array
class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        
        Trie trie = new Trie();

        PriorityQueue<int[]> queriesPq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            queriesPq.add(new int[] { query[0], query[1], i });
        }
        PriorityQueue<Integer> numsPq = new PriorityQueue<>();
        IntStream.range(0, nums.length).forEach(i -> numsPq.add(nums[i]));

        int ans[] = new int[queries.length];

        while (queriesPq.size() > 0) {
            int[] query = queriesPq.poll();
            int xi = query[0], mi = query[1];

            while (numsPq.size() > 0 && numsPq.peek() <= mi) {
                trie.insert(numsPq.poll());
            }
            if (trie.root.child[0] == null && trie.root.child[1] == null) {
                ans[query[2]] = -1;
            } else {
                ans[query[2]] = trie.getMax(xi);
            }
        }
        return ans;
    }

    class Node {
        Node[] child;

        Node() {
            this.child = new Node[2];
        }
    }

    class Trie {
        Node root = new Node();

        void insert(int num) {
            Node node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.child[bit] == null) {
                    node.child[bit] = new Node();
                }
                node = node.child[bit];
            }
        }

        int getMax(int num) {
            Node currentNode = root;
            int maxXOR = 0;

            for (int i = 31; i >= 0; i--) {

                int bit = (num >> i) & 1;
                int desiredBit = 1 - bit;

                if (currentNode.child[desiredBit] != null) {
                    currentNode = currentNode.child[desiredBit];
                    maxXOR = maxXOR | (1 << i);
                    
                } else {
                    currentNode = currentNode.child[bit];
                }
            }
            return maxXOR;
        }
    }

}