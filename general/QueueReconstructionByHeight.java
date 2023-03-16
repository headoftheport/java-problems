import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class QueueReconstructionByHeight {
    
    public int[][] reconstructQueue(int[][] people) {
        /*
         * time complexity: O(nlogn * n^2)
         * space complexity: O(1)
         */
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> ans = new ArrayList();
        for(int i = 0; i < people.length; i++){
            ans.add(people[i][1], people[i]);
        }
        
        return ans.toArray(new int[people.length][2]);
    }

    public int[][] reconstructQueue2(int[][] people) {
        /*
         * time complexity: O(nlogn * n^2)
         * space complexity: O(1)
         */
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[][] ans = new int[people.length][2];
        Set<Integer> index = new HashSet();
        
        for(int i = 0; i < people.length;i++){
            int count, j;
            System.out.println(people[i][0] + " " + people[i][1]);
            for(j=0, count = 0; j < people.length; j++){
                if(!index.contains(j)){
                    if(count == people[i][1]){
                        break;
                    }
                    count++;
                }
            }
            System.out.println(count);
            ans[j] = people[i];
            index.add(j);
        }
        
        return ans;
    }
}
