// Number of Operations to Make Network Connected
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class MakeConnectedSolution {
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
class RemoveStonesSolution {
    
    public int removeStones(int[][] stones) {
        int parent[] = new int[20001];
        for(int i = 0; i <= 20000; i++) parent[i] = i;
        for(int[] stone : stones) {
            int x = stone[0];
            int y = stone[1];
            union(parent, x, y + 10001);
        }
        Set<Integer> set = new HashSet<>();
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
class AccountsMergeSolution {
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

// Making A Large Island
class LargestIslandSolution {
    static class DisjointSet {
        int[] parent;
        int[] size;
        public DisjointSet(int n){
            parent = new int[n];
            size = new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }
        public int findParent(int n){
            if(parent[n]==n) return n;
            int up = findParent(parent[n]);
            parent[n] = up;
            return parent[n];
        }
        public void unionBySize(int a, int b){
            int upa = findParent(a);
            int upb = findParent(b);
            if(upa==upb) return;
            if(size[upa]<size[upb]){
                parent[upa] = upb;
                size[upb] += size[upa];
            }
            else{
                parent[upb] = upa;
                size[upa] += size[upb];
            }
        }
    }

    public int largestIsland(int[][] grid) {
        int c=0;
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        List<Integer> list = new ArrayList<>();
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    list.add(i*n+j);
                }
                else{
                    c++;
                    for(int k=0;k<4;k++){
                        int nRow = i + dx[k];
                        int nCol = j + dy[k];
                        if(nRow>=0 && nRow<n && nCol>=0 && nCol<n && grid[nRow][nCol]==1){
                            int curr = i*n+j; 
                            int adj = nRow*n+nCol;
                            ds.unionBySize(curr, adj);
                        }
                    }
                }
            }
        }
        if(c==n*n) return n*n;
        int ans = 0;
        for(int i : list){
            int row = i/n;
            int col = i%n;
            Set<Integer> set = new HashSet<>();
            for(int k=0;k<4;k++){
                int newRow = row + dx[k];
                int newCol = col + dy[k];
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<n && grid[newRow][newCol]==1){
                    set.add(ds.findParent(newRow*n+newCol));
                }
            }
            int curMax = 1;
            for(int l : set){
                curMax += ds.size[l];
            }
            ans = Math.max(curMax, ans);
        }
        return ans;
    }
}

// Swim in Rising Water
class SwimInWaterSolution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        pq.add(new int[] {0, 0, grid[0][0]});
        grid[0][0] = -1;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int max = curr[2];

            for(int x = 0; x < 4; x++) {
                int i = r + dx[x];
                int j = c + dy[x];

                if(i == -1 || j == -1 || i == n || j == n || grid[i][j] == -1) continue;
                int val = grid[i][j];
                int maxi = Math.max(max, val);
                grid[i][j] = -1;

                if(i == n - 1 && j == n - 1) return maxi;
                pq.add(new int[] {i, j, maxi});
            }
        }
        return 0;
    }
}