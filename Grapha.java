import java.util.*;

public class Grapha {
    private Map<String, Vertex> vertices;

    public Grapha() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(String label) {
        vertices.putIfAbsent(label, new Vertex(label));
    }

    public void addEdge(String from, String to, int weight) {
        Vertex v1 = vertices.get(from);
        Vertex v2 = vertices.get(to);
        if (v1 != null && v2 != null) {
            v1.addEdge(v2, weight);
            v2.addEdge(v1, weight);
        }
    }

    public void findShortestPath(String start, String end) {
        Vertex startVertex = vertices.get(start);
        Vertex endVertex = vertices.get(end);
        if (startVertex == null || endVertex == null) {
            System.out.println("One or both vertices not found");
            return;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));
        Map<Vertex, Integer> distances = new HashMap<>();
        Map<Vertex, Vertex> previous = new HashMap<>();
        Set<Vertex> visited = new HashSet<>();

        for (Vertex vertex : vertices.values()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(startVertex, 0);

        pq.add(new Edge(startVertex, 0));

        while (!pq.isEmpty()) {
            Edge currentEdge = pq.poll();
            Vertex currentVertex = currentEdge.getDestination();

            if (!visited.contains(currentVertex)) {
                visited.add(currentVertex);

                for (Edge neighborEdge : currentVertex.getEdges()) {
                    Vertex neighbor = neighborEdge.getDestination();
                    if (!visited.contains(neighbor)) {
                        int newDist = distances.get(currentVertex) + neighborEdge.getWeight();
                        if (newDist < distances.get(neighbor)) {
                            distances.put(neighbor, newDist);
                            previous.put(neighbor, currentVertex);
                            pq.add(new Edge(neighbor, newDist));
                        }
                    }
                }
            }
        }
        List<Vertex> path = new ArrayList<>();
        for (Vertex at = endVertex; at != null; at = previous.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);

        for (int i = 0; i < path.size() - 1; i++) {
            System.out.print(path.get(i).getLabel() + " -> " + path.get(i + 1).getLabel());
            if (i < path.size() - 2) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println("Total distance: " + distances.get(endVertex));
    }
}