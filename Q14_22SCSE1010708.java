import java.util.*;

public class Q14_22SCSE1010708 {
    public static List<Character> topologicalSort(Map<Character, List<Character>> graph) throws IllegalArgumentException {
        Map<Character, Integer> inDegree = new HashMap<>();
        for (Character node : graph.keySet()) {
            inDegree.put(node, 0);
        }

        for (List<Character> neighbors : graph.values()) {
            for (Character neighbor : neighbors) {
                inDegree.put(neighbor, inDegree.getOrDefault(neighbor, 0) + 1);
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        List<Character> topologicalOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            char node = queue.poll();
            topologicalOrder.add(node);
            List<Character> neighbors = graph.getOrDefault(node, new ArrayList<>());
            for (char neighbor : neighbors) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        for (int degree : inDegree.values()) {
            if (degree > 0) {
                throw new IllegalArgumentException("The graph contains a cycle.");
            }
        }

        return topologicalOrder;
    }

    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('A', Arrays.asList('B', 'C'));
        graph.put('B', Arrays.asList('D', 'E'));
        graph.put('C', Arrays.asList('E'));
        graph.put('D', Arrays.asList('F'));
        graph.put('E', Arrays.asList('F'));
        graph.put('F', new ArrayList<>());

        try {
            List<Character> topologicalOrder = topologicalSort(graph);
            System.out.println("Topological order: " + topologicalOrder);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
