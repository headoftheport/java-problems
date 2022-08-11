public class DivisorGame {
    
    public boolean divisorGame(int n) {
        
        Boolean[] store = new Boolean[n+1];
        
        for(int i = 0; i <= n; i++){
          store[i] = false; 
        }
        
        for(int i = 2; i <=n ; i++){
            int divisor = i / 2;
            while(divisor > 0){
                
                if(i % divisor == 0 && store[i-divisor] == false){
                    store[i] = true;
                    break;
                }
                
                divisor = divisor - 1;
                
            }
        }
        
        return store[store.length -1];
    }
    
}
