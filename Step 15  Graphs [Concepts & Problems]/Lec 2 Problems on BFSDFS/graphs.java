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