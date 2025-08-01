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