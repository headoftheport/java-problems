package Backtrack;

import java.util.List;
import java.util.ArrayList;

public class PalindromePartitioning {
    
    public List<List<String>> partition(String s) {
        
        return partitionString(s, 0);
        
    } 
    
    public List<List<String>> partitionString(String s, int start){
        

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
}
