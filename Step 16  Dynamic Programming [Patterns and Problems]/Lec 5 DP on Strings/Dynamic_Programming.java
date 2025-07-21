// Longest Common Subsequence

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()+1][text2.length()+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return lcs(text1, text2, 0, 0, dp);
    }

    int lcs(String s1, String s2 ,int i, int j, int[][] dp){
        if(i == s1.length() || j == s2.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = 1 + lcs(s1, s2, i+1, j+1, dp);
        }
        else{
            dp[i][j] = Math.max(lcs(s1, s2, i+1, j, dp), lcs(s1, s2, i, j+1, dp));
        }
        return dp[i][j];
    }
}

// Longest Palindromic Subsequence

class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int count=0;
        String rev="";
        for(int i=n-1;i>=0;i--)
        {
            rev+=s.charAt(i);
        }
        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0||j==0)
                dp[i][j]=0;
                else if(s.charAt(i-1)==rev.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else 
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
}

// Minimum Insertion Steps to Make a String Palindrome

class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder(s).reverse();
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int pdlen=longestPallindrome(s,sb,n-1,n-1,dp);
        return n-pdlen;

    }
    public static int longestPallindrome(String str,StringBuilder sb,int len1,int len2,int[][]dp){
        if(len1<0||len2<0)
            return 0;
        if(dp[len1][len2]!=-1)
            return dp[len1][len2];
        if(str.charAt(len1)==sb.charAt(len2))
            return 1+longestPallindrome(str,sb,len1-1,len2-1,dp);
        return dp[len1][len2]= Math.max(longestPallindrome(str,sb,len1-1,len2,dp),longestPallindrome(str,sb,len1,len2-1,dp));
    }
}

// Delete Operation for Two Strings

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        int lcm = dp[n][m];
        int ans = 0;
        if(n > lcm)
            ans += (n - lcm);
        if(m > lcm)
            ans += (m - lcm);
        return ans;
    }
}

// Shortest Common Supersequence 

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
      
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
     
        int i = m, j = n;
        StringBuilder result = new StringBuilder();
        
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
               
                result.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                result.append(str1.charAt(i - 1));
                i--;
            } else {
                result.append(str2.charAt(j - 1));
                j--;
            }
        }
        
        while (i > 0) {
            result.append(str1.charAt(i - 1));
            i--;
        }
        
        while (j > 0) {
            result.append(str2.charAt(j - 1));
            j--;
        }
        
       
        return result.reverse().toString();
    }
}

// Distinct Subsequences

class Solution {
    public int numDistinct(String s, String t) {
        if(t.length() > s.length() ) return 0;

        int[][] dp=new int[s.length()+1][t.length()+1];

        for(int si=0; si<=s.length(); si++) dp[si][t.length()]=1;
        
        for(int si=s.length()-1; si>=0; si--){
            for(int ti=t.length()-1; ti>=0; ti--){
                if(s.charAt(si)==t.charAt(ti)){
                    dp[si][ti]= dp[si+1][ti+1] + dp[si+1][ti];
                }
                else dp[si][ti]=dp[si+1][ti];
            }
        }
        return dp[0][0];
    }
}

// Edit Distance

class Solution {
    private int solve(int i, int j, String s1, String s2, int dp[][]) {
        if (i == 0 && j == 0) {
            if (s1.charAt(i) == s2.charAt(j))
                return 0;
            else
                return 1;
        }
        if (j == -1)
            return i + 1;
        if (i == -1)
            return j + 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        int insert = 300000000;
        int replace = 30000000;
        int delete = 30000000;

        if (s1.charAt(i) == s2.charAt(j)) 
            return dp[i][j] = solve(i - 1, j - 1, s1, s2, dp);
        else {
            insert = 1 + solve(i, j - 1, s1, s2, dp);
            replace = 1 + solve(i - 1, j - 1, s1, s2, dp);
            delete = 1 + solve(i - 1, j, s1, s2, dp);
        }

        return dp[i][j] = Math.min(insert, Math.min(replace, delete));
    }

    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];

        for (int[] I : dp)
            Arrays.fill(I, -1);

        return solve(word1.length() - 1, word2.length() - 1, word1, word2, dp);
    }
}

// Wildcard Matching

class Solution {
    public boolean match(int i, int j, String s, String p,Boolean[][] dp) {
        if (i < 0 && j < 0) return true;
        if (j < 0) return false;
      
        if (i < 0) return p.charAt(j) == '*' && match(i, j - 1, s, p,dp);
        if(dp[i][j]!=null)return dp[i][j];
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return dp[i][j]= match(i - 1, j - 1, s, p,dp);
        }
        if (p.charAt(j) == '*') {
            return dp[i][j]=match(i, j - 1, s, p,dp) || match(i - 1, j, s, p,dp);
        }
        return dp[i][j]=false;
    }
    public boolean isMatch(String s, String p) {
        Boolean[][] dp=new Boolean[s.length()][p.length()];
        return match(s.length() - 1, p.length() - 1, s, p,dp);
    }
}