import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

// Course Schedule
class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue queue = new LinkedList();
        int count=0;
        
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();
            
        for(int i=0; i<prerequisites.length;i++){
            degree[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for(int i=0; i<degree.length;i++){
            if(degree[i] == 0){
                queue.add(i);
                count++;
            }
        }
        
        while(queue.size() != 0){
            int course = (int)queue.poll();
            for(int i=0; i<graph[course].size();i++){
                int pointer = (int)graph[course].get(i);
                degree[pointer]--;
                if(degree[pointer] == 0){
                    queue.add(pointer);
                    count++;
                }
            }
        }
        if(count == numCourses)
            return true;
        else    
            return false;
    }
}

// Course Schedule II
class CourseScheduleII {
    public int[] findOrder(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int m =prerequisites.length;
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int indegree[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int topo[] = new int[n];
        int index = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo[index++] = node;
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }
        if (index == n) return topo;
        int[] arr = {};
        return arr;
    }
}

// Find Eventual Safe States
class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> l=new ArrayList<>();
        boolean[] safe=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            safe[i]=(graph[i].length==0);
        }
        for(int i=graph.length-1;i>=0;i--){
            boolean safeNode=true;
            for(int j=0;j<graph[i].length;j++){
                if(!safe[graph[i][j]]){
                    boolean[] isVisited=new boolean[graph.length];
                    safeNode=(safeNode && isSafeNode(graph,safe,graph[i][j],isVisited));    
                }
            }
            if(safeNode){
                safe[i]=true;
                l.addFirst(i);
            }
        }
        return l;
    }
    private boolean isSafeNode(int[][] graph,boolean[] safe,int num,boolean[] isVisited){
        if(graph[num].length==0 || graph[num]==null || safe[num]){
            return true;
        }
        if(isVisited[num]){
            return safe[num];
        }
        isVisited[num]=true;
        boolean safeNode=true;
        for(int i=0;i<graph[num].length;i++){
            safeNode=(safeNode && isSafeNode(graph,safe,graph[num][i],isVisited));
        }
        if(safeNode){
            safe[num]=true;
        }
        return safeNode;
    }
}