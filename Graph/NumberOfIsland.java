import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {
    int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    islands++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return islands;
    }
    
    
    
    public void dfs(char[][] grid, int x, int y, boolean[][] visited){
        if(x < 0 || x >= grid.length){
            return;
        }
        
        if(y < 0 || y >= grid[0].length){
            return;
        }
        
        if(visited[x][y] || grid[x][y] == '0'){
            return;
        }
        
        visited[x][y] = true;
        dfs(grid, x-1,y, visited);
        dfs(grid, x+1, y, visited);
        dfs(grid, x,y-1, visited);
        dfs(grid, x,y+1, visited);
        return;
        
    }


    public int numIslands2(char[][] grid){
        int rows = grid.length;
        int columns = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][columns];
        int count = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    count = count+1;
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                    bfs(grid,queue, visited);
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, Queue<int[]> queue, boolean[][] visited){
        int rows = grid.length;
        int columns = grid[0].length;
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            for(int[] dir: dirs){
                int x = node[0] + dir[0];
                int y = node[1] + dir[1];
                
                if(x < 0 || x >= rows || y < 0 || y >= columns || visited[x][y] || grid[x][y] == '0'){
                    continue;
                }
                queue.offer(new int[]{x, y});
                visited[x][y] = true;
            }
        }
    }
}

