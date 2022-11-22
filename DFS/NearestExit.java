
package DFS;

import java.util.Queue;
import java.util.LinkedList;

public class NearestExit {
    
    public int nearestExit(char[][] maze, int[] entrance) {
        /*
         * DFS solution
         * tc: O(m*n)
         * sc: O(max(m*n))
         */
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1]});
        int step = 0;
        maze[entrance[0]][entrance[1]] = '+';
        
        int[][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        
        while(!queue.isEmpty()){
            step = step + 1;
            int n = queue.size();
            for(int i = 0; i < n; i++){
                
                int[] curr = queue.poll();
                for(int j = 0 ; j < 4 ; j++){
                    
                    int x = curr[0] + directions[j][0];
                    int y = curr[1] + directions[j][1];
                    
                    if(x < 0 || y < 0 || x >= maze.length || y >= maze[0].length){
                        continue;
                    }
                    
                    if(maze[x][y] == '+'){
                        continue;
                    }
                    
                    if( x == 0 || y == 0 || x == maze.length-1 || y == maze[0].length-1 ){
                        return step;
                    }
                    maze[x][y] = '+';
                    queue.offer(new int[]{x, y});
                }
                
            }
        }
        
        return -1;
    }
}
