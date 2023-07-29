class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        List<String> ans = new ArrayList<String>();
        Set<String> hashSet = new HashSet<String>();
        hashSet.addAll(wordDict);
        dfs(s, 0, hashSet, ans, "");
        return ans;
    }
    
    public void dfs(String s, int index, Set<String> wordDict, List<String> ans, String curr){
        
        if(index == s.length()){
            ans.add(curr);
            return;
        }
        
        for(int i = index; i < s.length(); i++){
            
            String sub = s.substring(index, i+1);
            if(wordDict.contains(sub)){
                String next = curr == "" ? sub : curr + " " + sub;
                dfs(s, i+1, wordDict, ans, next);
            }
        }
    }
}
