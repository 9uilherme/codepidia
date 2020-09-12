package graph.v1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GraphTest {

    private static Graph graph;

    @BeforeAll
    static void setup(){
        graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(1, 0);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
    }

    @Test
    public void bfs(){
        List<Integer> bfs = graph.bfsTraverse(0);
        Assertions.assertEquals(Integer.valueOf(0), bfs.get(0));
        Assertions.assertEquals(Integer.valueOf(1), bfs.get(1));
        Assertions.assertEquals(Integer.valueOf(2), bfs.get(2));
        Assertions.assertEquals(Integer.valueOf(3), bfs.get(3));
        Assertions.assertEquals(Integer.valueOf(4), bfs.get(4));
        Assertions.assertEquals(Integer.valueOf(5), bfs.get(5));
        Assertions.assertEquals(Integer.valueOf(6), bfs.get(6));
        for(Integer elem : bfs) {
            System.out.print(elem + " ");
        }
    }

}
