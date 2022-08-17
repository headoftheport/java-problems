import java.util.List;
import java.util.Stack;

public class KeyAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        

        boolean[] visited = new boolean[rooms.size()];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while(!stack.empty()){
            Integer node = stack.pop();
            visited[node] = true;
            for(Integer nei: rooms.get(node)){
                stack.push(nei);
            }
        }

        for(boolean b: visited){
            if(!b){
                return false;
            }
        }
        return true;
    } 
    
}
