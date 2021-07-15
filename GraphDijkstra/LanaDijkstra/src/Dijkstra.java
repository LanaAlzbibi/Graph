import java.util.*;

public class Dijkstra {



    public  List<String> cheapestPath(Graph graph)
    {
        String start = graph.randomNode();
        String end = graph.randomNode();
        LinkedList<String> result = new LinkedList<>();
        Set<String> explored = new HashSet<>();
        Map<String, Edge> labels = new HashMap<>();
        PriorityQueue<Edge> edgeQueue = new PriorityQueue<>();
        // Step 1
        for (Edge e : graph.getEdges(start))
        {
            Edge edge = new Edge(start, e.getNodeConnectedTo(start), e.getCost());
            edgeQueue.add(edge);
            labels.put(edge.to, edge);
        }


        boolean done = false;
        while (!done)
        {
            // Step 2
            Edge smallestEdge = edgeQueue.remove();
            for (Edge e : graph.getEdges(smallestEdge.to))
            {
                String neighbor = e.getNodeConnectedTo(smallestEdge.to);
                if (!explored.contains(neighbor))
                {
                    if (!labels.containsKey(neighbor))
                    {
                        Edge edge = new Edge(smallestEdge.to, neighbor, smallestEdge.cost + e.getCost());
                        edgeQueue.add(edge);
                        labels.put(edge.to, edge);
                    }
                    else
                    {
                        Edge neighborEdge = labels.get(neighbor);
                        if (e.getCost() + smallestEdge.cost < neighborEdge.cost)
                        {
                            neighborEdge.cost = e.getCost() + smallestEdge.cost;
                            neighborEdge.from = smallestEdge.to;
                        }
                    }
                }
            }
            explored.add(smallestEdge.to);
            if (smallestEdge.to.equals(end))
                done = true;
        }
        // Step 4


        String current = end;
        result.addFirst(current);
        while (!current.equals(start))
        {
            current = labels.get(current).from;
            result.addFirst(current);
        }
        return result;

    }

    public  List<String> shortestPath(Graph graph)
    {
        graph.setCostToAllEdges(1);
        String start = graph.randomNode();
        String end = graph.randomNode();
        LinkedList<String> result = new LinkedList<>();
        Set<String> explored = new HashSet<>();
        Map<String, Edge> labels = new HashMap<>();
        PriorityQueue<Edge> edgeQueue = new PriorityQueue<>();
        // Step 1
        for (Edge e : graph.getEdges(start))
        {
            Edge edge = new Edge(start, e.getNodeConnectedTo(start), e.getCost());
            edgeQueue.add(edge);
            labels.put(edge.to, edge);
        }


        boolean done = false;
        while (!done)
        {
            // Step 2
            Edge smallestEdge = edgeQueue.remove();
            for (Edge e : graph.getEdges(smallestEdge.to))
            {
                String neighbor = e.getNodeConnectedTo(smallestEdge.to);
                if (!explored.contains(neighbor))
                {
                    if (!labels.containsKey(neighbor))
                    {
                        Edge edge = new Edge(smallestEdge.to, neighbor, smallestEdge.cost + e.getCost());
                        edgeQueue.add(edge);
                        labels.put(edge.to, edge);
                    }
                    else
                    {
                        Edge neighborEdge = labels.get(neighbor);
                        if (e.getCost() + smallestEdge.cost < neighborEdge.cost)
                        {
                            neighborEdge.cost = e.getCost() + smallestEdge.cost;
                            neighborEdge.from = smallestEdge.to;
                        }
                    }
                }
            }
            explored.add(smallestEdge.to);
            if (smallestEdge.to.equals(end))
                done = true;
        }
        // Step 4


        String current = end;
        result.addFirst(current);
        while (!current.equals(start))
        {
            current = labels.get(current).from;
            result.addFirst(current);
        }
        return result;
    }


    public static void main(String[] args)
        {
        Graph g = new Graph();
        Dijkstra d = new Dijkstra();
        g.addEdge("a", "b", 1);
        g.addEdge("a", "c", 9);
        g.addEdge("a", "d", 4);
        g.addEdge("b", "d", 2);
        g.addEdge("b", "e", 1);
        g.addEdge("c", "d", 5);
        g.addEdge("c", "f", 8);
        g.addEdge("d", "g", 9);
        g.addEdge("d", "e", 4);
        g.addEdge("d", "f", 2);
        g.addEdge("e", "g", 5);
        g.addEdge("f", "g", 1);
        g.addEdge("h", "e", 2);
        g.addEdge("h", "g", 1);
        g.addEdge("i", "f", 4);
        g.addEdge("i", "c", 3);
        g.addEdge("i", "j", 5);
        g.addEdge("j", "c", 6);

        System.out.println("The cheapest path between random Nodes is :\n " + d.cheapestPath(g));

        System.out.println("The shortest path between random Nodes is :\n " + d.shortestPath(g));
    }
}