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