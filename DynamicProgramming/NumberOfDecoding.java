class Solution {
    public int numDecodings(String s) {
        Integer[] ways = new Integer[s.length()+1];
        // ways[s.length()] = 1;
        return recurse(0, s, ways);
    }
    
    
    public int recurse(int pos, String s, Integer[] ways){
        
        int size = s.length();
        if(pos == size){
            return 1;
        }
        if(s.charAt(pos) == '0'){
            return 0;
        }
        if(ways[pos] != null){
            return ways[pos];
        }
        ways[pos] = recurse(pos+1, s, ways);
        if(pos < size - 1 && ( s.charAt(pos) == '1' || (s.charAt(pos) == '2' && s.charAt(pos+1) < '7'))){
             ways[pos] += recurse(pos+2, s, ways);
        }
        return ways[pos];
    }

    public int numDecodings2(String s) {
        
        int pos1 = 1;
        int pos2 = 0;
        
        
        for(int i = s.length()-1; i >= 0; i--){
            int dp = s.charAt(i) == '0' ? 0 : pos1;
                if(i <  s.length()-1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7'))){
                    dp += pos2;
                }
        
            pos2 = pos1;
            pos1 = dp;
        }
        return pos1;
    }

    public int numDecodings3(String s) {
        
        int[] dp = new int[s.length()+1];
        dp[s.length()] = 1;
        
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) != '0'){
                dp[i] = dp[i+1];
                if(i <  s.length()-1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7'))){
                    dp[i] += dp[i+1];
                }
            }
        }
        return dp[0];
    }
}

    

