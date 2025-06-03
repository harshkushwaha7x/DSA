// Number of Provinces

class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>>adj = new ArrayList<>();
        int m = isConnected.length;
        int n = isConnected[0].length;
        int[] vis = new int[m]; 
        int cnt = 0;
        for(int i=0;i<m;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < m;i++){
            for(int j = 0; j < n;j++){
              
                if(i != j && isConnected[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }

        for(int i = 0 ;i<m;i++){
            if(vis[i] != 1){
                dfs(adj,i,vis);
                cnt++;
            }
        }

        return cnt;
    }

    public void dfs( List<List<Integer>>adj,int src,int[] vis){
        vis[src] = 1;
        for(int ele:adj.get(src)){
            if(vis[ele] != 1){
                 dfs(adj,ele,vis);
            }
        }
    }
}

// Rotting Oranges

class Solution {
    int max = 0;
    int row;
    int col;
    int[][] DIRECTIONS = new int[][] { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
    
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        this.row = grid.length;
        this.col = grid[0].length;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[] {r, c, 0});
                }
            }
        }

        bfs(grid, queue);

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 1) {
                    return -1;
                }
            }
        }

        return max;
    }

    public void bfs(int[][] grid, Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] entry = queue.poll();
            int r = entry[0];
            int c = entry[1];
            int time = entry[2];

            max = Math.max(max, time);

            for (int[] dir : DIRECTIONS) {
                int new_r = r + dir[0];
                int new_c = c + dir[1];

                if (new_r >= 0 && new_r < row && new_c >= 0 && new_c < col && grid[new_r][new_c] == 1) {
                    grid[new_r][new_c] = 2;
                    queue.offer(new int[] {new_r, new_c, time + 1});
                }
            }
            
        }

        return;
    }
}