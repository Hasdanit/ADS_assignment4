import java.util.*;

public class Assign4_3 {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');

        graph.addEdge('A', 'C');
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'D');
        graph.addEdge('B', 'C');
        graph.addEdge('B', 'E');
        graph.addEdge('B', 'G');
        graph.addEdge('C', 'D');
        graph.addEdge('E', 'G');
        graph.addEdge('E', 'F');
        graph.addEdge('F', 'G');

        System.out.print("DFS: \n");
        Graph.depthFirstSearch('A');

        System.out.print("\n");

        System.out.print("BFS: \n");
        Graph.breadthFirstSearch('A');
    }
}

