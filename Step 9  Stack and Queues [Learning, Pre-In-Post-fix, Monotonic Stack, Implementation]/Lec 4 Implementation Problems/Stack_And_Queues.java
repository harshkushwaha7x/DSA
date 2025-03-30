import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

// Sliding Window Maximum

class SlidingWindowMaximum {
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

class LruCache {
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
    public LruCache(int capacity) {
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

// LFU Cache

class LfuCache {

    private final Map<Integer, CachedElement<Integer, Integer>> elements;

    private final TreeMap<Integer, LinkedList<Integer>> frequencies = new TreeMap<>();

    private final int capacity;

    public LfuCache(int capacity) {
        this.capacity = capacity;
        this.elements = new HashMap<>(capacity);
    }

    public int get(int key) {
        CachedElement<Integer, Integer> element = this.elements.get(key);
        if (element == null) {
            return -1;
        }

        incrementFrequency(element);

        return element.value;
    }

    public void put(int key, int value) {
        if (!this.elements.containsKey(key) && this.capacity == this.elements.size()) {
            this.removeLFU();
        }

        CachedElement<Integer, Integer> element = this.elements.get(key);
        if (element == null) {
            element = new CachedElement<>(key, value);
            this.addNew(element);
        } else {
            element.value = value;
            incrementFrequency(element);
        }

        this.elements.put(key, element);
    }

    private void addNew(CachedElement<Integer, Integer> element) {
        LinkedList<Integer> elementsOfOneFrequency = this.frequencies.getOrDefault(
                element.accessCount,
                new LinkedList<>()
        );
        elementsOfOneFrequency.addFirst(element.key);

        this.frequencies.put(element.accessCount, elementsOfOneFrequency);
    }

    private void removeLFU() {
        int elementsOfMinFrequencyKey = frequencies.firstKey();
        LinkedList<Integer> elementsOfMinFrequency = frequencies.remove(elementsOfMinFrequencyKey);
        int lfuKey = elementsOfMinFrequency.removeLast();

        if (!elementsOfMinFrequency.isEmpty()) {
            this.frequencies.put(elementsOfMinFrequencyKey, elementsOfMinFrequency);
        }

        this.elements.remove(lfuKey);
    }

    private void incrementFrequency(CachedElement<Integer, Integer> element) {
        LinkedList<Integer> elementsOfCurrentFrequency = this.frequencies.remove(element.accessCount);
        elementsOfCurrentFrequency.remove(element.key);

        if (!elementsOfCurrentFrequency.isEmpty()) {
            this.frequencies.put(element.accessCount, elementsOfCurrentFrequency);
        }

        element.accessCount++;

        LinkedList<Integer> elementsOfHigherFrequency = this.frequencies.getOrDefault(
                element.accessCount,
                new LinkedList<>()
        );
        elementsOfHigherFrequency.addFirst(element.key);
        this.frequencies.put(element.accessCount, elementsOfHigherFrequency);
    }

    private static class CachedElement<K, V> {

        private final K key;

        private V value;

        private int accessCount;

        CachedElement(K key, V value) {
            this.key = key;
            this.value = value;
            this.accessCount = 1;
        }
    }
}