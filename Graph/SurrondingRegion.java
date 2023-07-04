public class SurrondingRegion {
    
    public void solve(char[][] board) {

        /*
         * tc: 
         * sc:
         */
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m ; i++){
            if(board[i][0] == 'O'){
                solve(board, i, 0);
            }
            if(board[i][n-1] == 'O'){
                solve(board, i, n-1);
            }
        }
        
        for(int i = 0; i < n ; i++){
            if(board[0][i] == 'O'){
                solve(board, 0, i);
            }
            if(board[m-1][i] == 'O'){
                solve(board, m-1,i);
            }
        }
        
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    
    public void solve(char[][] board, int i, int j){
        
        
        if( i < 0  || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O'){
            return;
        }
        
        
        board[i][j] = '*';
        
        solve(board, i-1, j);
        solve(board, i+1, j);
        solve(board, i, j-1);
        solve(board, i, j+1);
        
        
    }
}
