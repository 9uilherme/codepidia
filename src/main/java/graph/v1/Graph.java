package graph.v1;

import java.util.LinkedList;
import java.util.List;

public class Graph {

    private int v;
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int a, int b) {
        adj[a].add(b);
    }

    public List<Integer> bfsTraverse(int a) {
        boolean [] visited = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(a);
        int point = 0;

        while (point != queue.size()) {
            if(visited[queue.get(point)]) {
                queue.remove(point);
                continue;
            }
            queue.addAll(adj[queue.get(point)]);
            visited[point] = true;
            point++;
        }

        return queue;
    }
}
