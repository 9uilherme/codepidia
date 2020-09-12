package graph.v1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Tree {

    private Node root;

    Tree() {
        this.root = null;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void traverseBFS() {
        if(this.root == null) return;
        LinkedList<Node> elems = new LinkedList<>();
        elems.add(root);
        while (!elems.isEmpty()) {
            Node elem = elems.removeFirst();
            System.out.println(elem.getData());
            elems.addAll(elem.getChildren());
        }
    }

    public void traverseDFS() {
        if(this.root == null) return;
        LinkedList<Node> elems = new LinkedList<>();
        elems.add(root);
        while (!elems.isEmpty()) {
            Node elem = elems.removeFirst();
            System.out.println(elem.getData());
            elems.addAll(0, elem.getChildren());
        }
    }

    public List<Integer> getLevelWidth(){
        LinkedList<Object> elems = new LinkedList<>();
        String random = UUID.randomUUID().toString();

        elems.add(root);
        elems.add(random);

        List<Integer> counter = new ArrayList<>();
        counter.add(0);

        while(elems.size() > 1) {
            Object elem = elems.removeFirst();
            if (elem instanceof String && elem.toString().equals(random)) {
                counter.add(0);
                elems.add(random);
            } else {
                assert elem instanceof Node;
                counter.set(counter.size()-1, counter.get(counter.size()-1) + 1);
                Node node = (Node) elem;
                System.out.println(node.getData().toString());
                elems.addAll(node.getChildren());
            }
        }
        return counter;
    }

}
