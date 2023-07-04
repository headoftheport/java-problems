class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length - 1;
        int n = board[0].length - 1;
        /*
         * tc: m * n * 8
         * sc: 1
         */
        for(int i = 0; i <= m ; i++){
            for(int j = 0; j <= n; j++){
                int lives = countLives(board, i, j, m, n);
                
                if(board[i][j] == 1 && lives >= 2 && lives <= 3){
                    board[i][j] = 3;
                }
                
                if(board[i][j] == 0 && lives == 3){
                    board[i][j] = 2;
                }
            }
        }
        
        for(int i = 0; i <= m ; i++){
            for(int j = 0; j <= n ; j++){
                board[i][j]  = board[i][j] >> 1;
            }
        }
    }
    
    
    public int countLives(int[][] board, int x, int y, int m, int n){
        
        int lives = 0;
        for(int i = Math.max(x-1, 0); i <= Math.min(x+1, m); i++ ){
            for(int j = Math.max(y-1, 0); j <= Math.min(y+1, n); j++){
                lives += board[i][j] & 1;
            }
        }
        
        lives -= board[x][y] & 1;
        return lives;
    }
}