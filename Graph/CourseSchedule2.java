import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<Integer>[] adj = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            adj[i] = new ArrayList<Integer>();
        }
        
        for(int[] edge: prerequisites){
            adj[edge[1]].add(edge[0]);
            indegree[edge[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        
        int[] ans = new int[numCourses];
        int index = 0;
        
        while(!queue.isEmpty()){
            int num = queue.poll();
            ans[index++] = num;
            
            for(Integer next: adj[num]){
                indegree[next]--;
                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
        
        if(index != numCourses){
            return new int[0];
        }
        
        return ans;
    }
    
    int i = 0;
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        
        List<Integer>[] adj = new ArrayList[numCourses];
        int[] visited = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            adj[i] = new ArrayList<Integer>();
        }
        
        for(int[] edge: prerequisites){
            adj[edge[0]].add(edge[1]);
        }
        
        int[] ans = new int[numCourses];
        
        for(int i=0; i < numCourses; i++){
            if(!dfs(i, adj, visited, ans)){
                return new int[0];
            }
        }
        
        return ans;
           
    }
    
    public boolean dfs(int index, List<Integer>[] adj, int[] visited, int[] ans){
        
        if(visited[index] == -1){
            return false;
        }
        
        if(visited[index] == 1){
            return true;
        }
        
        visited[index] = -1;
        
        for(int next: adj[index]){
            if(!dfs(next, adj, visited, ans)){
                return false;
            }
        }
        
        visited[index] = 1;
        ans[i++] = index; 
        return true;
    }
}