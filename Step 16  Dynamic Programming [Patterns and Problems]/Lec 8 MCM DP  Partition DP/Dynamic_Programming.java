// Minimum Cost to Cut a Stick
class Solution {

    int dfs(int[] newArr, int i, int j, Integer[][] memo) {
        if (i + 1 >= j) {
            return 0;
        }
        if (memo[i][j] != null)
            return memo[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int cost = dfs(newArr, i, k, memo) + dfs(newArr, k, j, memo) + (newArr[j] - newArr[i]);
            min = Math.min(cost, min);
        }
        memo[i][j] = min;
        return min;

    }

    public int minCost(int n, int[] cuts) {
        int size = cuts.length;
        int newArr[] = new int[size + 2];

        newArr[0] = 0;
        newArr[size+1] = n;

        for (int i = 0; i < size; i++) {
            newArr[i+1] = cuts[i];
        }
        Arrays.sort(newArr);
        Integer[][] memo = new Integer[size + 2][size + 2];

        return dfs(newArr, 0, size+1, memo);
    }
}

// Burst Balloons
class Solution {
    int [][] dp ;
    public int maxCoins(int[] nums) {
        dp = new int[nums.length][nums.length];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        return solve(nums,0,nums.length-1);
    }
    public int solve(int [] nums,int i,int j)
    {
        if(i>j) return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int max = 0;
        for(int k = i;k<=j;k++)
        {
            int temp = solve(nums,i,k-1) + solve(nums,k+1,j)+nums[k]*(i-1<0?1:nums[i-1])*(j+1>=nums.length?1:nums[j+1]);
            max = Math.max(max,temp);
        }
        return dp[i][j] = max;
    }
}

// Parsing A Boolean Expression
class Solution {
    int idx = 0;

    private boolean solveHelper(String expression) {
        char oper = expression.charAt(idx);
        idx += 2;

        char ch = expression.charAt(idx);
        boolean flag = false;
        if (ch == 't') {
            flag = true;
            idx++;
        } else if (ch == 'f') {
            flag = false;
            idx++;
        } else {
            flag = solveHelper(expression);
        }

        ch = expression.charAt(idx);
        while (ch != ')') {
            if (ch == ',') {
                ch = expression.charAt(++idx);
                continue;
            }

            boolean c_flg = false;
            if (ch == 't') {
                c_flg = true;
                idx++;
            } else if (ch == 'f') {
                c_flg = false;
                idx++;
            } else {
                c_flg = solveHelper(expression);
            }

            if (oper == '&') {
                flag &= c_flg;
            } else if (oper == '|') {
                flag |= c_flg;
            }

            ch = expression.charAt(idx);
        }
        idx++;
        return oper == '!' ? !flag : flag;
    }

    public boolean parseBoolExpr(String expression) {
        if (expression.length() == 1) {
            return expression.charAt(0) == 't';
        }
        return solveHelper(expression);
    }
}

// Palindrome Partitioning II
class Solution {
    public int minCut(String s) {
        
        int length = s.length ();
        char[] c = s.toCharArray ();
        boolean[][] dp = new boolean[length][length];
        
        for (int end = 0; end < length; end++) {
            for (int start = 0; start <= end; start++) {
                if (c[start] == c[end]) {
                    if (start == end) {
                        dp[start][end] = true;
                    }
                    else if (end - start == 1) {
                        dp[start][end] = true;
                    }
                    else if (dp[start + 1][end - 1]) {
                        dp[start][end] = true;
                    }
                }
            }
        }
        
        
        int[] minimumCuts = new int[length + 1];
        minimumCuts[0] = -1;
        
        for (int i = 0; i < length; i++) {
            minimumCuts[i + 1] = minimumCuts[i] + 1;
            
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j][i]) {
                    minimumCuts[i + 1] = Math.min (minimumCuts[i + 1], minimumCuts[j] + 1);
                }
            }
        }
        
        return minimumCuts[length];
    }
}