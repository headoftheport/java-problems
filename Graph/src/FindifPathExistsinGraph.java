import java.util.ArrayList;
import java.util.List;

public class FindifPathExistsinGraph {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind uf = new UnionFind(n);
        
        for(int[] edge: edges){
            uf.union(edge[0],edge[1]);
        }
        
        return uf.connected(source, destination);
    }


    public boolean validPathDfs(int n, int[][] edges, int source, int destination) {
        
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] v = new boolean[n];
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Integer>());
            v[i] = false;
        }
       
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        return dfs(adj, source, destination, v);
        
    }
    
    
    public boolean dfs(List<List<Integer>> adj, int s, int d, boolean[] v){
        
        if(s == d) return true;
        if (v[s] == true) return false;
        v[s] = true;
        for(int i: adj.get(s)){
            if(dfs(adj, i, d, v)) return true;
        }
        return false;
    }
    
}
