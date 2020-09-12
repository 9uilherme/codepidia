package questions.q2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeTest {

    BinarySearchTree binarySearchTree = new BinarySearchTree();
    private Node node5 = new Node(5);
    private Node node3 = new Node(3);
    private Node node1 = new Node(1);
    private Node node7 = new Node(7);
    private Node node9 = new Node(9);
    private Node node4 = new Node(4);
    private Node node6 = new Node(6);

    @BeforeEach
    public void setup() {
        binarySearchTree.insert(node5);
        binarySearchTree.insert(node3);
        binarySearchTree.insert(node1);
        binarySearchTree.insert(node1);
        binarySearchTree.insert(node7);
        binarySearchTree.insert(node9);
        binarySearchTree.insert(node4);
        binarySearchTree.insert(node6);
    }

    @Test
    public void shouldPrintPreOrder() {
        System.out.println("traversing pre order: ");
        binarySearchTree.traversePreOrder(node5);
    }

    @Test
    public void shouldPrintPosOrder() {
        System.out.println("traversing pos order: ");
        binarySearchTree.traversePosOrder(node5);
    }

    @Test
    public void shouldPrintInOrder() {
        System.out.println("traversing in order: ");
        binarySearchTree.traverseInOrder(node5);
    }

    @Test
    public void shouldPrintInOrderSubNode() {
        System.out.println("traversing in order: ");
        binarySearchTree.traverseInOrder(node3);
    }

    @Test
    public void shouldBFS() {
        System.out.println("traversing BFS: ");
        binarySearchTree.BFS(node5);
    }

    @Test
    public void shouldGetBFS() {
        System.out.println("traversing BFS: ");
        List<Node> nodes = new ArrayList<>();
        nodes.add(node5);
        nodes.add(node3);
        nodes.add(node7);
        nodes.add(node1);
        nodes.add(node4);
        nodes.add(node6);
        nodes.add(node9);
        Assertions.assertEquals(nodes, binarySearchTree.getBFS(node5));
    }

    @Test
    public void shouldPrintShortestPath() {
        System.out.println("Shortest Path: ");
        binarySearchTree.printShortestPath(node5, node9);
    }

}
