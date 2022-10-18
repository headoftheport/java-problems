public class wordSearch {

    public boolean exist(char[][] board, String word) {
        boolean visited[][] = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(search(board, i, j, word, 0, visited)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean search(char[][] board, int i, int j, String word, int index, boolean[][] visited){
            if(index >= word.length()){
                return true;
            }
            if((i < 0 || i > board.length-1) || (j < 0 || j > board[0].length-1) || board[i][j] != word.charAt(index) || visited[i][j]){
                return false;
            }
            // System.out.println(i + " " + j  + " " + index + " " + board[i][j]);
            visited[i][j] = true;
            if(search(board, i+1, j, word, index + 1, visited) ){
                return true;
            }
            if(search(board, i-1, j, word, index + 1, visited)){
                return true;
            }
            if(search(board, i, j+1,word, index +1, visited) ){
                return true;
            }
            if(search(board, i, j-1, word, index + 1, visited)){
                return true;
            }
            visited[i][j] = false;   
            return false;
    }
    
}
