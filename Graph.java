import java.util.*;

public class Graph {
    private static Map<Character, List<Character>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(char vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    public void addEdge(char source, char destination) {
        adjacencyList.get(source).add(destination);
    }

    public static void depthFirstSearch(char source) {
        Set<Character> visited = new HashSet<>();
        dfsUtil(source, visited);
    }

    private static void dfsUtil(char vertex, Set<Character> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");

        for (char neighbor : adjacencyList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    public static void breadthFirstSearch(char source) {
        Set<Character> visited = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();
        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            char vertex = queue.poll();
            System.out.print(vertex + " ");

            for (char neighbor : adjacencyList.get(vertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}