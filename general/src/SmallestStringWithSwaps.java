import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class SmallestStringWithSwaps {

    final static int N = 100001;
    boolean[] visited = new boolean[N];
    List<Integer>[] adj = new ArrayList[N];
    
    private void DFS(String s, int index, List<Character> chars, List<Integer> indices){
        
        chars.add(s.charAt(index));
        indices.add(index);
        
        visited[index] = true;
        
        for( int i: adj[index] ){
            if(!visited[i]){
                DFS(s,i,chars, indices);
            }
        }
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        for(int i=0; i < s.length(); i++){
            adj[i] = new ArrayList<Integer>();
        }
        
        for(List<Integer> edge: pairs){
            int source = edge.get(0);
            int dest = edge.get(1);
            
            adj[source].add(dest);
            adj[dest].add(source);    
        }
        
        char[] answer = new char[s.length()];
        for(int vert = 0; vert < s.length(); vert++){
            
            if(!visited[vert]){
               List<Character> chars = new ArrayList<>();
                List<Integer> indices = new ArrayList<>();
                
                DFS(s,vert,chars, indices );
                
                Collections.sort(chars);
                Collections.sort(indices);
                
                for(int i = 0; i < chars.size(); i++){
                    answer[indices.get(i)] = chars.get(i);
                }
                
            }
        }
        
        return new String(answer);
        
    }
    
}
