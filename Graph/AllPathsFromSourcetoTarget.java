import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourcetoTarget {

    private List<List<Integer>> storageList;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            
        return dfs(graph, 0, graph.length-1);
        
    }
    
    public List<List<Integer>> dfs(int[][] graph, int start, int end){
        
        List<List<Integer>> returnList = new ArrayList<>();
        if(start == end){
            returnList.add(new ArrayList<Integer>(List.of(end)));
            return returnList;
        }
        
        for(int i: graph[start]){
            List<List<Integer>> temp = dfs(graph, i, end);
            for(List<Integer> j: temp){
                j.add(0,start);
                returnList.add(j);
            }   
        }
        
        return returnList;
    }


    public List<List<Integer>> allPathsSourceTarget2(int[][] graph){
        /*
         * Using Backtracking method
         */
        this.storageList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        backtrack(graph, 0, graph.length - 1, path);
        return this.storageList;
    }

    public void backtrack(int[][] graph, int curr, int dest, List<Integer> path){

        if(curr == dest){
            this.storageList.add(new ArrayList<Integer>(path));
        }

        for(int i: graph[curr]){
            path.add(i);
            backtrack(graph, i, dest, path);
            path.remove(path.size()-1);
        }
    }
    
}
