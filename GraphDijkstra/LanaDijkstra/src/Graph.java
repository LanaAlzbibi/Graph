import java.util.*;


public class Graph
{
    private ArrayList<String> nodes;


    private Set<Edge> edges;
    private Map<String, Map<String, Edge>> neighbors;
    public Graph()
    {
        neighbors = new HashMap<>();
        edges = new HashSet<>();
        nodes = new ArrayList<>();
    }


    public String randomNode()
    {
        Random random = new Random();
        return nodes.get(random.nextInt(nodes.size()));
    }



    public Collection<Edge> getEdges(String nodeName)
    {
        return neighbors.get(nodeName).values();
    }


    public void setCostToAllEdges(int cost)
    {
        for(Edge e : edges)
        {
            e.cost=cost;
        }
    }


    public void addEdge(String from, String to, double cost)
    {
        if (!neighbors.containsKey(from))
            neighbors.put(from, new HashMap<>());
        if (!neighbors.containsKey(to))
            neighbors.put(to, new HashMap<>());
        Edge newEdge = new Edge(from, to, cost);
        edges.add(newEdge);


        if(!nodes.contains(from))
            nodes.add(from);
        else if (!nodes.contains(to))
            nodes.add(to);


        if (neighbors.get(from).containsKey(to))
            throw new IllegalArgumentException("Edge from " + from + " to " + to + " already exists");
        neighbors.get(from).put(to, newEdge);
        neighbors.get(to).put(from, newEdge);
    }

    public ArrayList<String> getNodes()
    {
        return nodes;
    }
}