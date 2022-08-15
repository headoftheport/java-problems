import java.util.List;
import java.util.ArrayList;

public class MinNodeRequeired {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        /*
         * time complexity: O(k)
         * space complexity: O(n)
         */
        int[] indegree = new int[n];
        List<Integer> ans = new ArrayList<Integer>();

        for (List<Integer> edge : edges) {
            indegree[edge.get(1)]++;
        }

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }

    public List<Integer> findSmallestSetOfVertices2(int n, List<List<Integer>> edges) {
        /*
         * time complexity: O(k)
         * space complexity: O(n)
         */
        boolean[] indegree = new boolean[n];
        List<Integer> ans = new ArrayList<Integer>();

        for (List<Integer> edge : edges) {
            indegree[edge.get(1)] = true;
        }

        for (int i = 0; i < n; i++) {
            if (indegree[i] == false) {
                ans.add(i);
            }
        }
        return ans;
    }
}
