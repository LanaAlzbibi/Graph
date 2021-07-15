

public class Edge implements Comparable<Edge>
{

    String to;
    String from;
    double cost;
    public Edge(String from, String to, double cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }



    public double getCost()
    {
        return cost;
    }



    public String getNodeConnectedTo(String nodeName) {
        if (nodeName.equals(from))
            return to;
        else if (nodeName.equals(to))
            return from;
        else
            return nodeName+" does not connect with any Node";
    }





    @Override
    public int compareTo(Edge o)
    {
        return Double.compare(cost, o.cost) ;
    }




}
