class Solution {
    
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[][] store = new int[rows][cols];
        for(int i=0; i < rows; i++){
            for(int j = 0; j <  cols; j++){
                store[i][j] = -1;
            }
        }
        
        int ans = 0;
        
        for(int i=0; i < rows; i++){
            for(int j = 0; j <  cols; j++){
                ans = Math.max(ans, dfs(i, j, matrix, store));
            }
        }
        
        return ans;
    }
    
    public int dfs(int x, int y, int[][] matrix, int[][] store){
        
        if(store[x][y] != -1){
            return store[x][y];
        }
        
        int temp = 0;
        for(int[] dir: directions){
            int nx = dir[0] + x;
            int ny = dir[1] + y;
            
            if(nx >= 0 && nx < matrix.length && ny >= 0 && ny < matrix[0].length && matrix[nx][ny] > matrix[x][y]){
                temp = Math.max(temp, dfs(nx, ny, matrix, store));
            }
        }
        
        store[x][y] = 1 + temp;
        return store[x][y];
    }
}
