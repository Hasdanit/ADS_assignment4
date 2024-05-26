import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String label;
    private List<Edge> edges;

    public Vertex(String label) {
        this.label = label;
        this.edges = new ArrayList<>();
    }

    public String getLabel() {
        return label;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Vertex destination, int weight) {
        this.edges.add(new Edge(destination, weight));
    }

    @Override
    public String toString() {
        return label;
    }
}
