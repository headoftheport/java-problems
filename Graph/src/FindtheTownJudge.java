import java.util.List;
import java.util.ArrayList;

public class FindtheTownJudge {


    public int findJudge(int n, int[][] trust) {
        /*
         * time complexity: O(n)
         * space complexity: O(2n)
         */

        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> adj2 = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<Integer>());
            adj2.add(new ArrayList<Integer>());
        }
        
        for(int[] edge: trust){
            adj.get(edge[1]).add(edge[0]);
            adj2.get(edge[0]).add(edge[1]);
        }
        
        
        for(int i=1; i<=n; i++){
            if(adj.get(i).size() == n-1 && adj2.get(i).size() == 0){
                return i;
            }
        }
        
        return -1;
    }


    public int findJudgeDegreeCount(int n, int[][] trust){

         /*
         * time complexity: O(n)
         * space complexity: O(2n)
         */

        int[] indegree = new int[n+1];
        int[] outdegree = new int[n+1];

        for(int[] edge: trust){
            indegree[edge[1]]++;
            outdegree[edge[0]]++;
        }

        for(int i = 1; i <=n; i++){
            if(indegree[i] == n-1 && outdegree[i] == 0) return i;
        }

        return -1;
    }

    public int findJudgeSingleArray(int n, int[][] trust){

        int[] indegree = new int[n+1];

        for(int[] edge: trust){
            indegree[edge[1]]++;
            indegree[edge[0]]--;
        }

        for(int i = 1; i <=n; i++){
            if(indegree[i] == n-1) return i;
        }

        return -1;
    }
    
}
