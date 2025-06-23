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

// Accounts Merge

class Solution {
    static class DSU {
        int[] parent;
        int[] size;
        public DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findParent(int x) {
            if(x == parent[x]) return x;
            return parent[x] = findParent(parent[x]);
        }

        public void union(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);
            if(pu == pv) return;
            if(size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);
        Map<String, Integer> map = new HashMap<>();

        // find the owner of each mail and store
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if(!map.containsKey(email)) {
                    map.put(email,i);
                } else {
                    dsu.union(i, map.get(email));
                }
            }
        }

        List<String>[] mails = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            mails[i] = new ArrayList<>();
        }

        // based on parents, group mails
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int index = dsu.findParent(entry.getValue());
            mails[index].add(key);
        }

        List<List<String>> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(mails[i].size() == 0) 
                continue;
            Collections.sort(mails[i]);
            List<String> ls = new ArrayList<>();
            ls.add(accounts.get(i).get(0));
            for(String m : mails[i]) {
                ls.add(m);
            }
            list.add(ls);
        }

        return list;
    }
}