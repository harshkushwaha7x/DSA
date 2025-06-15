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

// Cheapest Flights Within K Stops

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            adj.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int[] {flight[1], flight[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {src, 0});
        int stops = 0;

        while (!q.isEmpty() && stops <= k) {
            int sz = q.size();
            while (sz-- > 0) {
                int[] curr = q.poll();
                int node = curr[0];
                int distance = curr[1];

                if (!adj.containsKey(node)) continue;

                for (int[] next : adj.get(node)) {
                    int neighbour = next[0];
                    int price = next[1];
                    if (price + distance >= dist[neighbour]) continue;
                    dist[neighbour] = price + distance;
                    q.offer(new int[] {neighbour, dist[neighbour]});
                }
            }
            stops++;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}

// Network Delay Time

class Solution {
    public int networkDelayTime(int[][] times, int n, int K) {
        int[][] graph = new int[n][n];
        for(int i = 0; i < n ; i++) Arrays.fill(graph[i], Integer.MAX_VALUE);
        for( int[] rows : times) graph[rows[0] - 1][rows[1] - 1] =  rows[2];        
        
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K - 1] = 0;
        
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n ; i++){
            int v = minIndex(distance, visited);
            if(v == -1)continue;
            visited[v] = true;
            for(int j = 0; j < n; j++){
                if(graph[v][j] != Integer.MAX_VALUE){
                    int newDist = graph[v][j] + distance[v];
                    if(newDist < distance[j]) distance[j] = newDist;
                }
            }
        }
        int result = 0;
        for(int dist : distance){
            if(dist == Integer.MAX_VALUE) return -1;
            result = Math.max(result, dist);
        }
        return result;
    }
	
    private int minIndex(int[] distance, boolean[] visited){
        int min = Integer.MAX_VALUE, minIndex = -1;
        for(int i = 0; i < distance.length; i++){
            if(!visited[i] && distance[i] < min){
                min = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}

// Number of Ways to Arrive at Destination

class Solution {
  public int countPaths(int n, int[][] roads) {
    List<Pair<Integer, Integer>>[] graph = new List[n];

    for (int i = 0; i < n; i++)
      graph[i] = new ArrayList<>();

    for (int[] road : roads) {
      final int u = road[0];
      final int v = road[1];
      final int w = road[2];
      graph[u].add(new Pair<>(v, w));
      graph[v].add(new Pair<>(u, w));
    }

    return dijkstra(graph, 0, n - 1);
  }

  private int dijkstra(List<Pair<Integer, Integer>>[] graph, int src, int dst) {
    final int MOD = 1_000_000_007;
    long[] ways = new long[graph.length];
    Arrays.fill(ways, 0);
    long[] dist = new long[graph.length];
    Arrays.fill(dist, Long.MAX_VALUE);

    ways[src] = 1;
    dist[src] = 0;
    Queue<Pair<Long, Integer>> minHeap = new PriorityQueue<>(Comparator.comparing(Pair::getKey)) {
      { offer(new Pair<>(dist[src], src)); }
    };

    while (!minHeap.isEmpty()) {
      final long d = minHeap.peek().getKey();
      final int u = minHeap.poll().getValue();
      if (d > dist[u])
        continue;
      for (Pair<Integer, Integer> pair : graph[u]) {
        final int v = pair.getKey();
        final int w = pair.getValue();
        if (d + w < dist[v]) {
          dist[v] = d + w;
          ways[v] = ways[u];
          minHeap.offer(new Pair<>(dist[v], v));
        } else if (d + w == dist[v]) {
          ways[v] += ways[u];
          ways[v] %= MOD;
        }
      }
    }

    return (int) ways[dst];
  }
}