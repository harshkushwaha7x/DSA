import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

// Sliding Window Maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            if (i % k == 0)
                lmax[i] = nums[i];
            else
                lmax[i] = Math.max(lmax[i - 1], nums[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1 || (i + 1) % k == 0)
                rmax[i] = nums[i];
            else
                rmax[i] = Math.max(rmax[i + 1], nums[i]);
        }

        for (int i = 0; i <= n - k; i++) {
            ans[i] = Math.max(rmax[i], lmax[i + k - 1]);
        }

        return ans;
    }
}

// Online Stock Span

class StockSpanner {
    Stack<Integer> prices;
    Stack<Integer> days; 
    public StockSpanner() {
        prices=new Stack<>();
        days=new Stack<>();
    }
    
    public int next(int price) {
        int ans=1;
        while(!prices.isEmpty() && prices.peek()<=price){
            prices.pop();
            ans+=days.pop();
        }
        prices.push(price);
        days.push(ans);
        return ans;
    }
}

// LRU Cache

class LRUCache {
    private int capacity;
    private Map<Integer,Node> map;
    private Node tail, head;
    class Node{
        int key,value;
        Node prev, next;
        Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail; 
        tail.prev=head; 
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            remove(node);
            addToFront(node);
            return node.value;
        }
        return -1;
    }
    private void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    private void addToFront(Node node){
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
    }
    private void moveToHead(Node node){
        remove(node);
        addToFront(node);
    }
    private Node removeTail(){
        Node lru=tail.prev;
        remove(lru);
        return lru;
    }
    public void put(int key, int value) {
         if(map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;
            moveToHead(node);
         }
         else{
            Node newNode=new Node(key,value);
            addToFront(newNode);
            map.put(key,newNode);

            if(map.size()>capacity){
                Node lru=removeTail();
                map.remove(lru.key);
            }
         }
    }
}

