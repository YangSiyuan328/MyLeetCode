package DifficultQuestion;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Q1192_CriticalConnectionsInANetwork {


    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Graph graph = new Graph();
        for (List<Integer> connection : connections) {
            Node node1 = new Node(connection.get(0));
            Node node2 = new Node(connection.get(1));
            Edge edge1 = new Edge(node1, node2);
            Edge edge2 = new Edge(node2, node1);
            graph.nodes.put(node1.value, node1);
            graph.nodes.put(node2.value, node2);
            graph.edges.add(edge1);
            graph.edges.add(edge2);
        }

        return null;
    }


    private static class Graph {
        public HashMap<Integer, Node> nodes;
        public HashSet<Edge> edges;

        public Graph() {
            nodes = new HashMap<>();
            edges = new HashSet<>();
        }
    }

    private static class Node {
        public int value;
        public int edgeNum;
        public ArrayList<Node> neighbor;
        public ArrayList<Edge> edges;

        public Node(int value) {
            this.value = value;
            edgeNum = 0;
            neighbor = new ArrayList<>();
            edges = new ArrayList<>();
        }
    }

    private static class Edge {
        final static int weight = 1;
        public Node from;
        public Node to;

        public Edge(Node from, Node to) {
            this.from = from;
            this.to = to;
        }

    }
}
