// Palindrome Partitioning
class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        partition(0, s, list, res);
        return res;
    }

    private void partition(int idx, String s, List<String> list, List<List<String>> res) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                list.add(s.substring(idx, i + 1));
                partition(i + 1, s, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int st, int end) {
        while (st < end) {
            if (s.charAt(st) != s.charAt(end))
                return false;
            st++;
            end--;
        }
        return true;
    }
}

// Word Search
class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        if (m*n < word.length())
            return false;
        char[] wrd = word.toCharArray();
        int[] boardf = new int[128];
        for (int i = 0; i < m; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                ++boardf[board[i][j]];
            }
        }
        for (char ch : wrd)
        {
            if (--boardf[ch] < 0)
            {
                return false;
            }
        }
        if (boardf[wrd[0]] > boardf[wrd[wrd.length - 1]])
            reverse(wrd);
        for (int i = 0; i < m; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                if (wrd[0] == board[i][j]
                    && found(board, i, j, wrd, new boolean[m][n], 0))
                    return true;
            }
        }
        return false;
    }

    private void reverse(char[] word)
    {
        int n = word.length;
        for (int i = 0; i < n/2; ++i)
        {
            char temp = word[i];
            word[i] = word[n - i - 1];
            word[n - i - 1] = temp;
        }
    }
    private static final int[] dirs = {0, -1, 0, 1, 0};
    private boolean found(char[][] board, int row, int col, char[] word,
                        boolean[][] visited, int index)
    {
        if (index == word.length)
            return true;
        if (row < 0 || col < 0 || row == board.length || col == board[0].length
            || board[row][col] != word[index] || visited[row][col])
            return false;
        visited[row][col] = true;
        for (int i = 0; i < 4; ++i)
        {
            if (found(board, row + dirs[i], col + dirs[i + 1],
                word, visited, index + 1))
                return true;
        }
        visited[row][col] = false;
        return false;
    }
}

// N-Queens
class NQueens {
    public List<List<String>> solveNQueens(int n) {
        
        char [][] board = new char[n][n];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        queen(board, 0, ans);
        return ans;
    }

    static void queen(char[][] board, int row, List<List<String>> list) {

        if(row == board.length) {

            list.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if(isSafe(board, row, col)) {
                board[row][col] = 'Q';
                queen(board, row + 1, list);
                board[row][col] = '.';
            }
        }
    }

    static List<String> construct(char[][] board) {

        List<String> internal = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String row = new String(board[i]);
            internal.add(row);
        }
        return internal;
    }

    static boolean isSafe(char[][] board, int row, int col) {

        for (int i = 0; i < row; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        int maxLeft = Math.min(row, col);

        for (int i = 1; i <= maxLeft; i++) {
            if(board[row - i][col - i] == 'Q') {
                return false;
            }
        }

        int maxRight = Math.min(row, board.length - 1 - col);

        for (int i = 1; i <= maxRight; i++) {
            if(board[row - i][col + i] == 'Q') {
                return false;
            }
        }

        return true;
    }
}

// Rat in a Maze Problem - I
class RatInAMaze {
    private void solve(int r,int c,ArrayList<ArrayList<Integer>> mat,int n,ArrayList<String> ans,String move,boolean[][] visited,int[] di,int[] dj){
        if(r==n-1 && c==n-1){
            ans.add(move);
            return;
        }
        String dir="DLRU";
        for(int i=0;i<4;i++){
            int nexti=r+di[i];
            int nextj=c+dj[i];
            if(nexti>=0 && nextj>=0&& nexti<n&& nextj<n&& !visited[nexti][nextj]&&mat.get(nexti).get(nextj)==1){
                visited[nexti][nextj]=true;
                solve(nexti,nextj,mat,n,ans,move+dir.charAt(i),visited,di,dj);
                visited[nexti][nextj]=false;
            }
        }
    }
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        int n=mat.size();
        ArrayList<String> res=new ArrayList<>();
        if (mat.get(0).get(0) == 0 || mat.get(n - 1).get(n - 1) == 0) return res;
        boolean[][] visited=new boolean[n][n];
        int di[]=new int[]{1,0,0,-1};
        int dj[]=new int[]{0,-1,1,0};
        visited[0][0]=true; 
        solve(0,0,mat,n,res,"",visited,di,dj);
        return res;
    }
}

// Word Break
class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        return recWay1(s, wordDict);
    }

    boolean recWay2(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length() + 1];
        return wordBreak2(s, new HashSet<>(wordDict), 0, memo);
    }

    boolean wordBreak2(String s, Set<String> wordDict, int k, Boolean[] memo) {
        int n = s.length();
        if (k == n) return true;

        if (memo[k] != null) return memo[k];

        for (int i=k + 1; i<=n; i++) {
            String word = s.substring(k, i);
            if (wordDict.contains(word) && wordBreak2(s, wordDict, i, memo)) {
                return memo[k] = true;
            }
        }

        return memo[k] = false;
    }

    boolean recWay1(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length() + 1];
        return wordBreak(s, wordDict, 0, memo);
    }
    
    boolean wordBreak(String s, List<String> wordDict, int k, Boolean[] memo) {
        if (k == s.length()) {
            return true;
        }
        
        if (memo[k] != null) {
            return memo[k];
        }
        
        for (int i=0; i<wordDict.size(); i++) {
            String word = wordDict.get(i);
            if (s.startsWith(word, k)) {
                if(wordBreak(s, wordDict, k + word.length(), memo)) return memo[k] = true;
            }
        }
                   
        return memo[k] = false;
    }
}

// M-Coloring Problem
class MColoringProblem {
    boolean graphColoring(int v, List<int[]> edges, int m) {
        // code here
        int[] nodeColor = new int[v];
        return backtrack(0, v, edges, m, nodeColor);
    }
    boolean backtrack(int node, int v, List<int[]> edges, int m, int[] nodeColor){
        if(node == v) return true;
        
        for(int color = 1; color <= m; color++){
            if(isSafe(node, edges, color, nodeColor)){
                nodeColor[node] = color;
                if(backtrack(node +1, v,edges, m, nodeColor)) return true;
                nodeColor[node] =0;
            }
        }
        return false;
    }
    boolean isSafe(int node, List<int[]> edges,int color, int[] nodeColor){
        
        for(int[] edge : edges){
            if(edge[0] == node && nodeColor[edge[1]] == color) return false;
            if(edge[1] == node && nodeColor[edge[0]] == color) return false;
        }
        return true;
    }
}

// Sudoku Solver
class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) { 
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;

                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false; 
                }
            }
        }
        return true; 
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) return false;

            if (board[i][col] == c) return false;

            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == c) return false;
        }
        return true;
    }
}

// Expression Add Operators
class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String>ans=new ArrayList<>();
        solve(0,num,target,"",ans,0,0);
        return ans;
    }
    private void solve(int index,String num,int target,String curr,List<String>ans,long prev,long res){
        if(index==num.length()){
            if(res==target){
                ans.add(curr);
            }
            return;
        }
        String st="";
        long curres=0;
        for(int i=index;i<num.length();i++){
            if(i>index && num.charAt(index)=='0')break;
            st+=num.charAt(i);
            curres=curres*10+(num.charAt(i)-'0');
            if(index==0){
                solve(i+1,num,target,st,ans,curres,curres);
            }
            else{
                solve(i+1,num,target,curr+"+"+st,ans,curres,res+curres);
                solve(i+1,num,target,curr+"-"+st,ans,-curres,res-curres);
                solve(i+1,num,target,curr+"*"+st,ans,prev*curres,res-prev+(prev*curres));
            }
        }
    }
}
