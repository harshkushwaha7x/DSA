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

// Flood Fill

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int img[][]=new int[image.length][image[0].length];
        for(int i=0;i<image.length;i++)
            for(int j=0;j<image[0].length;j++)
                img[i][j]=image[i][j];
        int inicolor=image[sr][sc];
        int vis[][]=new int[image.length][image[0].length];
        int dx[]={-1,0,+1,0};
        int dy[]={0,+1,0,-1};
        
        dfs(sr,sc,dx,dy,vis,img,color,inicolor);
        return img;
    }
    public void dfs(int sr,int sc,int dx[],int dy[],int vis[][],int img[][],int color,int inicolor)
    {
        vis[sr][sc]=1;
        img[sr][sc]=color;
        for(int i=0;i<4;i++)
        {
            int nr=sr+dx[i];
            int nc=sc+dy[i];
            if(nr>=0 && nc>=0 && nr<img.length && nc<img[0].length && vis[nr][nc]==0 && img[nr][nc]==inicolor)
            {
                dfs(nr,nc,dx,dy,vis,img,color,inicolor);
            }
        }
    }
}

// 01 Matrix

class Solution {
    int m, n;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int[][] updateMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        
        int[][] result = new int[m][n];
        
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                    que.offer(new int[] {i, j});
                }
                else {
                    result[i][j] = -1;
                }
            }
        }

        while (!que.isEmpty()) {
            int[] cell = que.poll();
            int i = cell[0];
            int j = cell[1];
            
            for (int[] dir : directions) {
                
                int new_i = i + dir[0];
                int new_j = j + dir[1];
                
                if(new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && result[new_i][new_j] == -1) {
                    result[new_i][new_j] = result[i][j] + 1;
                    que.add(new int[] {new_i, new_j});
                }
            }
        }
        
        return result;
    }
}

// Surrounded Regions

class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for(int r = 0 ; r<n ; r++){
            if(board[r][0]=='O') cross_connection(board, r , 0, n, m);
            if(board[r][m-1]=='O') cross_connection(board, r, m-1, n, m);
        }

        for(int c =0 ; c<m ; c++){
            if(board[0][c]=='O') cross_connection(board, 0 , c, n , m);
            if(board[n-1][c]=='O') cross_connection(board, n-1, c , n , m);
        }

        for(int i = 0;i<n; i++){
            for(int j =0; j<m ; j++){
                if(board[i][j]=='O') board[i][j]='X';
                else if(board[i][j]=='T') board[i][j]='O';
            }
        }
    }
    public void cross_connection(char[][]board, int i , int j, int n , int m){
        if(i<0 || i>=n || j<0 || j>=m || board[i][j]!='O') return;

        board[i][j] = 'T';
        cross_connection(board, i-1, j, n , m);
        cross_connection(board, i+1, j, n , m);
        cross_connection(board, i, j-1, n , m);
        cross_connection(board, i, j+1, n , m);
    }
}

// Number of Enclaves

class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        for(int i = 0;i<n;i++){
            if(grid[i][0]==1){
                dfs(grid,visited,i,0,n,m);
            }
            if(grid[i][m-1] == 1){
                dfs(grid,visited,i,m-1,n,m);
            }
        }
        for(int i = 0;i<m;i++){
            if(grid[0][i] == 1){
                dfs(grid,visited,0,i,n,m);
            }
            if(grid[n-1][i] ==1){
                dfs(grid,visited,n-1,i,n,m);
            }
        }
        int ans = 0;
        for(int i = 1;i<n-1;i++){
            for(int j = 1;j<m-1;j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    ans++;
                }
            }
        }
        return ans;
    }
    void dfs (int[][] grid,boolean[][] visited,int row,int col,int n ,int m){
        int[] temprow = {1,-1,0,0};
        int[] tempcol = {0,0,1,-1};

        visited[row][col] = true;

        for(int i = 0;i<4;i++){
            int nrow = row+temprow[i];
            int ncol = col+tempcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !visited[nrow][ncol] && grid[nrow][ncol]==1){
                dfs(grid,visited,nrow,ncol,n,m);
            }
        }
    }
}

// Word Ladder

class Solution {
    public List<String>getNeighbours(String word, HashSet<String>set){
        List <String>neighbours = new ArrayList<>();
        for(int i =0; i<word.length();i++){
            for(char ch='a';ch<='z';ch++){
                if(ch==word.charAt(i)){
                    continue;
                }
                String newWord=word.substring(0,i)+ch+word.substring(i+1,word.length());
                if(set.contains(newWord)){
                    neighbours.add(newWord);
                }
            }
        }
        return neighbours;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        if(set.contains(beginWord)){
            set.remove(beginWord);
        }
        int level = 0;
        while(!queue.isEmpty()){
            int curLevelSize = queue.size();
            for(int i =0;i<curLevelSize;i++){
                String node = queue.poll();
                if(node.equals(endWord)){
                    return level+1;
                }
                List<String> neighbour=getNeighbours(node,set);
                for(String word: neighbour){
                    if(set.contains(word)){
                        queue.offer(word);
                        set.remove(word);
                    }
                }
            }
            level++;
        }
        return 0;
    }
}

// Word Ladder II

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return new ArrayList<>();

        Map<String, List<String>> parents = new HashMap<>();
        Set<String> currentLevel = new HashSet<>();
        currentLevel.add(beginWord);
        Set<String> visited = new HashSet<>();
        boolean found = false;

        while (!currentLevel.isEmpty() && !found) {
            Set<String> nextLevel = new HashSet<>();
            visited.addAll(currentLevel);

            for (String word : currentLevel) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    char original = chs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        chs[i] = c;
                        String nextWord = new String(chs);
                        if (!wordSet.contains(nextWord) || visited.contains(nextWord)) continue;

                        if (!parents.containsKey(nextWord)) {
                            parents.put(nextWord, new ArrayList<>());
                        }
                        parents.get(nextWord).add(word);

                        if (nextWord.equals(endWord)) found = true;
                        nextLevel.add(nextWord);
                    }
                    chs[i] = original;
                }
            }
            currentLevel = nextLevel;
        }

        List<List<String>> res = new ArrayList<>();
        if (found) {
            List<String> path = new LinkedList<>();
            backtrack(endWord, beginWord, parents, path, res);
        }
        return res;
    }

    private void backtrack(String word, String beginWord, Map<String, List<String>> parents,
                           List<String> path, List<List<String>> res) {
        if (word.equals(beginWord)) {
            path.add(0, word);
            res.add(new ArrayList<>(path));
            path.remove(0);
            return;
        }

        if (!parents.containsKey(word)) return;

        path.add(0, word);
        for (String parent : parents.get(word)) {
            backtrack(parent, beginWord, parents, path, res);
        }
        path.remove(0);
    }
}