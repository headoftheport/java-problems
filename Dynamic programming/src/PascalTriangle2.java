import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {

    public List<Integer> getRow(int rowIndex) {
        
        List<Integer> ans = new ArrayList<Integer>(rowIndex+1);
        ans.add(1);
        for(int i=1; i<=rowIndex; i++){
            for(int j=i-1; j>=1; j--){
                int temp = ans.get(j-1) + ans.get(j);
                ans.set(j, temp);
            }
            ans.add(1);
        }
        
        return ans;
        
    }

    public List<Integer> getRow2(int rowIndex) {

        long nCk = 1;
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<=rowIndex;i++){
            result.add((int)nCk);
            nCk = nCk *(rowIndex-i)/(i+1);
        }
        return result;

    }
    
}
