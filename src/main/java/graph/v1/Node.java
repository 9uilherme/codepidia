package graph.v1;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class Node<T> {
    private T data;
    private LinkedList<Node> children;

    Node(T data) {
        this.data = data;
        this.children = new LinkedList<>();
    }

    public void add(Node node){
        this.children.add(node);
    }

    public void remove(T data) {
        this.children = children.stream()
                .filter(node -> !node.getData().equals(data))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    T getData() {
        return data;
    }

    LinkedList<Node> getChildren() {
        return children;
    }
}
