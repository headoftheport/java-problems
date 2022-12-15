class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                Boolean rowcol = validRowCol(board, i, j);
                Boolean square = isValidSquare(board, i, j);
                // System.out.println(i + " " + j + " " + rowcol + " " + square);
                if(!rowcol || !square){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    
    public boolean validRowCol(char[][] board, int row, int col){
            
        for(int i = row+1; i < 9; i++){
            if(board[row][col] == board[i][col]){
                return false;
            }
        }
        
        for(int i = col+1; i < 9; i++){
            if(board[row][col] == board[row][i] ){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isValidSquare(char[][] board, int row, int col){
        int rowStart = row / 3 * 3;
        int colStart = col / 3 * 3;
        
        for(int i = rowStart; i < rowStart+ 3; i++){
            for(int j = colStart; j < colStart + 3; j++){
                if(i != row && j != col && board[i][j] == board[row][col]){
                    return false;
                }
            }
        }
        
        return true;
    }
}
