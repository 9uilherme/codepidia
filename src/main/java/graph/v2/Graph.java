package graph.v2;

import java.util.LinkedList;

public class Graph {
    public Node[] nodes = null;

    public boolean hasRoute(int nodeA, int nodeB) {
        setVisitedFalse();
        if (nodes == null) return false;
        if (nodes.length < nodeA || nodes.length < nodeB) return false;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(nodes[nodeA]);

        while (!queue.isEmpty()) {
            Node curr = queue.removeFirst();
            curr.visited = true;
            if (curr.equals(nodes[nodeB])) return true;
            if (curr.children == null) continue;
            for (Node child : curr.children) {
                if (child.visited) continue;
                queue.add(child);
            }
        }
        return false;
    }

    public void setVisitedFalse(){
        if (nodes == null) return;
        for (Node n :
                nodes) {
            n.visited = false;
        }
    }

}
