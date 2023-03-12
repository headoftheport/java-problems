package trie;

import java.util.List;
import java.util.ArrayList;

public class FindNWords {

    public List<String> findWords(char[][] board, String[] words) {
        /*
         * tc: O((m*n)(4* max_length(words)))
         * sc: O((words)*len(word))
         */
        TrieNode root = buildTrie(words);
        List<String> ans = new ArrayList<String>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, i, j, ans, root);
            }
        }
        return ans;
    }
    
    
    public void dfs(char[][] board, int row, int col, List<String> ans, TrieNode root){
        char c = board[row][col];
        if(c == '#' || root.next[c-'a'] == null){
            return;
        }
        root = root.next[c-'a'];
        if(root.word != null){
            ans.add(root.word);
            root.word = null;
        }
        
        board[row][col] = '#';
        
        if(row > 0){
            dfs(board, row-1, col, ans, root );
        }
        if(row < board.length-1){
            dfs(board, row + 1, col, ans, root);
        }
        if(col > 0){
            dfs(board, row, col - 1, ans, root);
        }
        if(col < board[0].length-1){
            dfs(board, row, col+1, ans, root);
        }
        
        board[row][col] = c;
    }
    
    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word: words){
            TrieNode curr = root;
            for(char c: word.toCharArray()){
                int index = c - 'a';
                if(curr.next[index] == null){
                    curr.next[index] = new TrieNode();
                }
                curr = curr.next[index];
            }
            
            curr.word = word;
        }
        
        return root;
    }
    
    public class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    
}
