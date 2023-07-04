import java.util.Queue;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
 
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<String>();
        
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet();
        
        queue.offer(s);
        visited.add(s);
        
        Boolean found = false;
        
        while(!queue.isEmpty()){
            String curr = queue.poll();
            
            if(checkValidity(curr)){
                ans.add(curr);
                found = true;
            }
            
            if(found == true){
                continue;
            }
            
            for(int i = 0 ; i < curr.length(); i++){
                if(curr.charAt(i) != ')' && curr.charAt(i) != '('){
                    continue;
                }
                
                String temp = curr.substring(0, i) + curr.substring(i+1);
                
                if(!visited.contains(temp)){
                    queue.offer(temp);
                    visited.add(temp);
                }
            }
        }
        
        return ans;
        
    }
    
    
    public Boolean checkValidity(String s){
        
        int sum = 0;
        
        for(Character c: s.toCharArray()){
            if(c == '('){
                sum++;
            }
            if(c == ')'){
                sum--;
            }
            
            if(sum < 0){
                return false;
            }
        }
        
        return sum == 0;
    }

    public List<String> removeInvalidParentheses2(String s) {
        List<String> ans = new ArrayList<String>();
        recurse(s, ans, 0, 0, '(', ')');
        return ans;
    }
    
    public void recurse(String s, List<String> ans, int next, int change, char open, char close ){
        int openCount = 0;
        int closeCount = 0;
        for(int i = next; i < s.length(); i++){
            if(s.charAt(i) == open){
                openCount++;
            }
            if(s.charAt(i) == close){
                closeCount++;
            }
            if(closeCount > openCount){
                for(int j = change; j  <= i; j++ ){
                    if(s.charAt(j) == close && (j == change || s.charAt(j - 1) != close)){
                        recurse(s.substring(0, j) + s.substring(j+1, s.length()), ans, i, j, open, close);

                    }
                }
                                        return;
            }
        }
        
        String reverse = new StringBuilder(s).reverse().toString();
        if(open == '('){
            recurse(reverse, ans, 0, 0, ')', '(');
        }
        else{
            ans.add(reverse);
        }
    }
} 