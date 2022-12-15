public class LargestPalSubstring {

    public String longestPalindrome(String s) {
        /*
         * expand around centre
         * time: O(n2)
         * space: O(1)
         */
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++){
            System.out.println(start + " " + end);
            int len1 = expandAroundCentre(s, i, i);
            int len2 = expandAroundCentre(s, i, i+1);
            int max = Math.max(len1, len2);
            System.out.println(len1 + " " + len2);
            if( max > end - start){
                start = i - (max-1)/ 2;
                end = i + max / 2;
            } 
        }
        
        return s.substring(start, end+1);
        
    }
    
    public int expandAroundCentre(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        
        return j - i - 1;
    }

    public String longestPalindrome(String s) {
        /*
         * Dynamic programming
         * time: O(n2)
         * space: o(n2)
         */
        
        boolean dp[][] = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = true;
        }
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j <= i; j++){
                dp[j][i] = s.charAt(i) == s.charAt(j) && ( j + 1 >= i - 1 || dp[j+1][i-1]);
                if(dp[j][i] == true &&  i-j > end - start ){
                    start = j;
                    end = i;
                }
            }
        }
        
        return s.substring(start, end+1);
    
}
    
}
