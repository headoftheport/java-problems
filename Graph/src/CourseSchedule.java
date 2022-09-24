import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CourseSchedule{

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /*
         * topological sorting
         * time: O(E + V)
         * space: O(E + V)
         * 
         */
        List<Integer>[] adj = new LinkedList[numCourses];
        int[] indegree = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            adj[i] = new LinkedList<>();
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
        int edgeCount = prerequisites.length;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int edge: adj[curr]){
                edgeCount--;
                if(--indegree[edge] == 0){
                    queue.offer(edge);
                }
            }
        }
        
        return edgeCount == 0;
        
        
    }


    public boolean canFinish2(int numCourses, int[][] prerequisites) {

        /*
         * dfs to find the cycle
         * time: O(E + V)
         * space: O(E + V)
         * 
         */
        
        List<Integer>[] adj = new LinkedList[numCourses];
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            adj[i] = new LinkedList<>();
            visited[i] = 0;
        }
        for(int[] edge: prerequisites){
            adj[edge[1]].add(edge[0]);
        }
        
        for(int i = 0; i < numCourses; i++ ){
            if(visited[i] == 0 && !dfs(adj, visited, i)){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean dfs(List<Integer>[] adj, int[] visited, int curr){
        
        if(visited[curr] == -1){
            return false;
        }
        
        if(visited[curr] == 1){
            return true;
        }
        
        visited[curr] = -1;
        for(int next: adj[curr]){
            if(!dfs(adj, visited, next)){
                return false;
            }
        }
        visited[curr] = 1;
        return true;
    }
}