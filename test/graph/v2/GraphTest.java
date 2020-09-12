package graph.v2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GraphTest {

    private static Graph graph;

    @BeforeEach
    public void setup(){
        Node node0 = new Node("0");
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");

        node0.children = new Node[3];
        node0.children[0] = node1;
        node0.children[1] = node4;
        node0.children[2] = node5;

        node1.children = new Node[1];
        node1.children[0] = node3;

        node2.children = new Node[1];
        node2.children[0] = node1;

        node3.children = new Node[2];
        node3.children[0] = node2;
        node3.children[1] = node4;

        graph = new Graph();
        graph.nodes = new Node[6];
        graph.nodes[0] = node0;
        graph.nodes[1] = node1;
        graph.nodes[2] = node2;
        graph.nodes[3] = node3;
        graph.nodes[4] = node4;
        graph.nodes[5] = node5;
    }

    @Test
    public void shouldCheckRouteTrue() {
        Assertions.assertTrue(graph.hasRoute(1, 3));
        Assertions.assertTrue(graph.hasRoute(0, 3));
        Assertions.assertTrue(graph.hasRoute(3, 2));
        Assertions.assertTrue(graph.hasRoute(0, 2));
        Assertions.assertTrue(graph.hasRoute(1, 2));
    }

    @Test
    public void shouldCheckRouteFalse() {
        Assertions.assertFalse(graph.hasRoute(4, 3));
    }


}
