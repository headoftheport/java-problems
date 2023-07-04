class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for(int i = 0; i < isConnected.length; i++){
            if(!visited[i]){
                count++;
                dfs(visited, i, isConnected);
            }
        }
        
        return count;
    }
    
    public void dfs(boolean[] visited, int index, int[][] isConnected){
        
        visited[index] = true;
        
        for(int i = 0 ; i < isConnected.length;i++){
            if(!visited[i] && isConnected[index][i] == 1){
                dfs(visited, i, isConnected);
            }
        }
    }
}
