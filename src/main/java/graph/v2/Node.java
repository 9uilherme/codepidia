package graph.v2;

public class Node {
    public String name;
    public Node [] children = null;
    public boolean visited;

    public Node(String name) {
        this.name = name;
        this.visited = false;
    }
}
