import java.util.ArrayList;
import java.util.List;

public class LongestIncreaseSub {
    
    public int lengthOfLIS(int[] nums) {
        
        List<Integer> arr = new ArrayList<Integer>();
        for(int i: nums){
            if(arr.size() == 0 || arr.get(arr.size()-1) < i){
                arr.add(i);
            }
            else{
                int s = 0;
                int e = arr.size()-1;
                while(s < e){
                    int m = (s+e) / 2;
                    if(arr.get(m) < i){
                        s = m+1;
                    }else{
                        e = m;
                    }
                }
                  
                arr.set(s, i);
                }
            }
        return arr.size();
    }
}
