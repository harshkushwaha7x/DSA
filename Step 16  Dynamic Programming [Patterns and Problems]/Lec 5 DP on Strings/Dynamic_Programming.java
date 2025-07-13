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