//Palindrome Partitioning

class Solution {
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

class Solution {
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

class Solution {
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

class Solution {
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

class Solution {
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