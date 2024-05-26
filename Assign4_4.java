import java.util.*;

public class Assign4_4{
    public static void main(String[] args) {
        Grapha g = new Grapha();
        String[][] edges = {
                {"Edinburgh", "Stirling", "50"},
                {"Stirling", "Glasgow", "50"},
                {"Stirling", "Perth", "40"},
                {"Perth", "Dundee", "60"},
                {"Stirling", "Edinburgh", "70"}
        };

        for (String[] edge : edges) {
            g.addVertex(edge[0]);
            g.addVertex(edge[1]);
            g.addEdge(edge[0], edge[1], Integer.parseInt(edge[2]));
        }

        System.out.println("Shortest path from Edinburgh to Dundee:");
        g.findShortestPath("Edinburgh", "Dundee");
    }
}