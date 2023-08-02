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
}