import java.util.ArrayList;
import java.util.Random;
public class RandomGenerator {


    private ArrayList<String> nodes;
    private Random random = new Random();
    private int vertex;
    private int edge;
    private int count;

    Graph g = new Graph();


    public RandomGenerator() {
    }
    // You will need a constructor that takes the number of vertices for your graph and the number of edge
    public RandomGenerator(int vertex, int edge, int count) {
        this.vertex = vertex;
        this.edge = edge;
        this.count = count;
    }

    public void randomEdges() {
        for (int i = 0; i < count; i++) {
            char c = randomVertex();
            char x = randomVertex();
            int y = random.nextInt(50);
//            g.addEdge(c, x, y);
        }
    }

    public char randomVertex(){

        char c = (char)(random.nextInt(26) + 'a');
        return c;
    }

    public String randomNode()
    {   nodes = g.getNodes();
        int y = random.nextInt(nodes.size());
        return nodes.get(y);
    }
}