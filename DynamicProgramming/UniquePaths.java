public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        return helper(grid, m-1, n-1);
        
    }
    
    public int helper(int[][] grid, int m, int n){
        
        if( m < 0 || n < 0){
            return 0;
        }
        
        if((m == 0 && n == 0) || (m == 0 && n == 1) || (m == 1 && n == 0)){
            grid[m][n] = 1;
            return 1;
        }
        
        if(grid[m][n] != 0){
            return grid[m][n];
        }
        
        grid[m][n] = helper(grid, m-1, n) + helper(grid, m, n-1);
        return grid[m][n];
        
        
    }

    public int uniquePaths2(int m, int n) {
        
        int[][] grid = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if( i == 0 || j == 0){
                    grid[i][j] = 1;
                }
                else{
                    grid[i][j] = grid[i][j-1] + grid[i-1][j];
                }
            }
        }
        return grid[m-1][n-1];
            
        
    }

    public int uniquePaths3(int m, int n){
        if (m == 1 || n == 1){
            return 1;
        }

        m--;
        n--;

        long res = 1;
        int div = 1;
        for(int i = m + 1; i <= m+n; i++, div++){
            res = res * i;
            res = res / div;
        }
        return (int)res
    }
    
}
