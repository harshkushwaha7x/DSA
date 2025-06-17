// Number of Operations to Make Network Connected

class Solution {
    public int makeConnected(int n, int[][] connections) {
        int[] parent = new int[n];
        
        for(int i = 0; i < n; i++) parent[i] = i;
        
        int cycles = 0;
        int unconnected_computers = 0;
        
        for(int[] link : connections) {
            int from = link[0];
            int to = link[1];
            
            if(find_parent(from, parent) == find_parent(to, parent)) cycles++;
            
            union(from, to, parent);
        }
        
        for(int i = 0; i < n; i++) {
            if(parent[i] == i) unconnected_computers++;
        }
        
        if(cycles >= unconnected_computers - 1) return unconnected_computers - 1;
        return -1;
    }
    
    public int find_parent(int node, int[] parent) {
        if(parent[node] == node) return node;
        return find_parent(parent[node], parent);
    }
    
    public void union(int from, int to, int[] parent) {
        from = find_parent(from, parent);
        to = find_parent(to, parent);
        
        parent[to] = from;
    }
}

// Most Stones Removed with Same Row or Column

class Solution {
    
    public int removeStones(int[][] stones) {
        int parent[] = new int[20001];
        for(int i = 0; i <= 20000; i++) parent[i] = i;
        for(int[] stone : stones) {
            int x = stone[0];
            int y = stone[1];
            union(parent, x, y + 10001);
        }
        Set<Integer>set = new HashSet<>();
        for(int[] stone : stones) {
            set.add(find_parent(parent, stone[0]));
        }
        return stones.length - set.size();
    }

    void union(int[] parent, int x, int y) {
        int parX = find_parent(parent, x);
        int parY = find_parent(parent, y);
        if(parX != parY) parent[parY] = parX;
    }

    int find_parent(int[] parent, int ind) {
        if(parent[ind] == ind) return ind;
        return parent[ind] = find_parent(parent, parent[ind]);
    }
}