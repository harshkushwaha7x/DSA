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