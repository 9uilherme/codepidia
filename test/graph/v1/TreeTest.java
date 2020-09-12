package graph.v1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TreeTest {

    private static Tree t;

    @BeforeAll
    static void setup(){
        Node node1 = new Node<>(1);
        Node node2 = new Node<>(2);
        Node node3 = new Node<>(3);
        Node node4 = new Node<>(4);
        Node node5 = new Node<>(5);
        Node node6 = new Node<>(6);
        Node node7 = new Node<>(7);

        node1.add(node2);
        node1.add(node3);
        node2.add(node4);
        node2.add(node5);
        node3.add(node6);
        node3.add(node7);
        t = new Tree();
        t.setRoot(node1);
    }

    @Test
    public void shouldTraverseBFS(){
        t.traverseBFS();
    }

    @Test
    public void shouldTraverseDFS(){
        t.traverseDFS();
    }

    @Test
    public void getLevelWidth(){
        List<Integer> counter = t.getLevelWidth();
        Assertions.assertEquals(Integer.valueOf(1), counter.get(0));
        Assertions.assertEquals(Integer.valueOf(2), counter.get(1));
        Assertions.assertEquals(Integer.valueOf(4), counter.get(2));
    }

}
