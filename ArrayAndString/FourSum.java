import java.util.Map;
import java.util.HashMap;

public class FourSum {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        
        Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
        int size = nums2.length;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                int sum = nums1[i] + nums2[j];
                sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
            }
        }
        
        int res = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                int sum = nums3[i] + nums4[j];
                res += sumMap.getOrDefault(-sum, 0);
            }
        }
        
        return res;
        
    }
}
