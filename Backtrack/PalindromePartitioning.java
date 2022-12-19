package Backtrack;

import java.util.List;
import java.util.ArrayList;

public class PalindromePartitioning {
    
    public List<List<String>> partition(String s) {
        
        return partitionString(s, 0);
        
    } 
    
    public List<List<String>> partitionString(String s, int start){
        
        /*
         * time: (N*2^N)
         * space: (N)
         */
        int curr = start;
        List<List<String>> array = new ArrayList<>();
        if(start >= s.length()){
            array.add(new ArrayList<String>());
            return array;
        }
        StringBuilder sb = new StringBuilder();
        while (curr < s.length()){
            sb.append(s.charAt(curr));
            if(checkPalindrome(s, start, curr)){
                List<List<String>> temp = partitionString(s, curr+1);
                for(List<String> iter: temp){
                    iter.add(0, sb.toString());
                    array.add(iter);
                }
            }
            curr++;
        }
        
        return array;
    }
    
    public boolean checkPalindrome(String s, int start, int end){
        
        for(int i = start, j = end; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        
        return true;
    }
    
    public void partitionString2(String s, List<List<String>> result, List<String> temp, int pos){
        /*
         * time: (N*2^N)
         * space: (N)
         */
        if(pos >= s.length()){
            result.add(new ArrayList<String>(temp));
            return;
        }
        int curr = pos;
        while(curr < s.length()){
            if(checkPalindrome(s, pos, curr)){
                temp.add(s.substring(pos, curr+1));
                partitionString2(s, result, temp, curr+1);
                temp.remove(temp.size() - 1);
            }
            curr++;
        }
        
        return;
        
    }

    public void dfs(List<List<String>> result, String s, int start, List<String> currentList, boolean[][]dp){

        /*
         * DFS approach
         */
        if (start >= s.length()){
            result.add(new ArrayList<>(currentList));
            return;
            
        }
        for(int end = start; end < s.length(); end++){
            if(s.charAt(start) == s.charAt(end) && ( end - start <= 2 || dp[start+1][end-1])){
                dp[start][end] = true;
                currentList.add(s.substring(start, end+1));
                dfs(result, s, end+1, currentList, dp);
                currentList.remove(currentList.size()-1);
            }
        }
        return;
    }

    public List<List<String>> partition2(String s) {
        int len = s.length();
        String[][] store = new String[len][len];
        for(int i = 0 ; i < len; i++){
            for(int j = i; j < len ; j++){
                if(checkPalindrome(s, i, j)){
                    store[i][j] = s.substring(i, j+1);
                }
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        dfs2(result, store, 0, new ArrayList<>());
        return result;
    }
    
    public void dfs2( List<List<String>> result,  String[][] store, int pos, List<String> array){
        if(pos >= store.length){
            result.add(array);
        }
        
        if(pos == store.length-1){
            array.add(store[pos][pos]);
            result.add(array);
            return;
        }
        
        for(int i = pos; i < store.length; i++){
            if(store[pos][i] != null){
                List<String> temp = new ArrayList<>(array);
                temp.add(store[pos][i]);
                dfs2(result, store, i+1, temp);
            }
        }
        return;
    }
    
}
