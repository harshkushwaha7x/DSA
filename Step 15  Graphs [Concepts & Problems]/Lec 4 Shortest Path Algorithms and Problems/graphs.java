// Shortest Path in Binary Matrix

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        if(n == 1 && grid[0][0] == 0) return 1;
        
        Deque<int[]> queue = new ArrayDeque<>(); 
        queue.add(new int[] {0, 0, 1});
        
        while(!queue.isEmpty()) {
            int[] curr = queue.pollFirst();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            for(int i = r - 1; i <= r + 1; i++) {
                for(int j = c - 1; j <= c + 1; j++) {
                    if(i == -1 || i == n || j == -1 || j == n || grid[i][j] == 1) continue;
                    if(n - 1 == i && n - 1 == j) return dist + 1;
                    else {
                        queue.add(new int[] {i, j, dist + 1});
                        grid[i][j] = 1; 
                    }
                }
            }
        }
        return -1;
    }
}

// Path With Minimum Effort

class Solution {
    static class Edge {
        int effort, row, col;
        Edge(int e, int r, int c) {
            this.effort = e;
            this.row = r;
            this.col = c;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        pq.offer(new Edge(0, 0, 0));

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int e = edge.effort;
            int r = edge.row;
            int c = edge.col;

            if (r == n - 1 && c == m - 1) return e;

            for (int i = 0; i < 4; i++) {
                int nRow = r + dx[i];
                int nCol = c + dy[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m) {
                    int currentEffort = Math.abs(heights[r][c] - heights[nRow][nCol]);
                    int maxEffort = Math.max(e, currentEffort);

                    if (dist[nRow][nCol] > maxEffort) {
                        dist[nRow][nCol] = maxEffort;
                        pq.offer(new Edge(maxEffort, nRow, nCol));
                    }
                }
            }
        }

        return 0;
    }
}