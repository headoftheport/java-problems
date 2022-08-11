import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String v = equations.get(i).get(0);
            String u = equations.get(i).get(1);

            graph.putIfAbsent(v, new HashMap());
            graph.get(v).put(u, values[i]);
            graph.putIfAbsent(u, new HashMap());
            graph.get(u).put(v, 1 / values[i]);

        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            result[i] = dfs(graph, queries.get(i).get(0), queries.get(i).get(1), new HashSet<String>());
        }

        return result;

    }

    
    public Double dfs(Map<String, Map<String, Double>> graph, String start, String end, Set<String> visited) {
        if (!graph.containsKey(start)) {
            return -1.0;
        }

        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }

        visited.add(start);
        for (Map.Entry<String, Double> neighbour : graph.get(start).entrySet()) {
            if (!visited.contains(neighbour.getKey())) {
                double value = dfs(graph, neighbour.getKey(), end, visited);
                if (value != -1) {
                    return neighbour.getValue() * value;
                }
            }

        }

        return -1.0;
    }

}
