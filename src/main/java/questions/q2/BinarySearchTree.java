package questions.q2;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@NoArgsConstructor
@AllArgsConstructor
public class BinarySearchTree {

    Node root;

    public void insert(Node item) {
        insert(root, item);
    }

    public void insert(Node parent, Node item) {
        if (root == null) {
            root = item;
            return;
        }
        if (parent == null) parent = root;
        if (item.data < parent.data) {
            if (parent.left == null){
                parent.left = item;
                item.parent = parent;
            }
            else insert(parent.left, item);
        } else if (item.data > parent.data) {
            if (parent.right == null) {
                parent.right = item;
                item.parent = parent;
            }
            else insert(parent.right, item);
        }
    }

    /* DFS */
    public void traversePreOrder(Node n) {
        if (n == null) return;
        visit(n);
        traversePreOrder(n.left);
        traversePreOrder(n.right);
    }

    /* Leaf before */
    public void traversePosOrder(Node n) {
        if (n == null) return;
        traversePosOrder(n.left);
        traversePosOrder(n.right);
        visit(n);
    }

    /* ordered */
    public void traverseInOrder(Node n) {
        if (n == null) return;
        traverseInOrder(n.left);
        visit(n);
        traverseInOrder(n.right);
    }

    public void BFS (Node node) {
        List<Node> nodes = new ArrayList<>();
        if (root == null) {
            return;
        }
        if (node == null) node = root;
        nodes.add(node);

        while (nodes.size() != 0) {
            Node n = nodes.remove(0);
            visit(n);
            if (n.left != null) nodes.add(n.left);
            if (n.right != null) nodes.add(n.right);
        }
    }

    public void printShortestPath(Node a, Node b){
        Node n = b;
        Stack<Node> nodes = new Stack<>();
        while (n != null) {
            nodes.push(n);
            if (n.equals(a)) break;
            n = n.parent;
        }
        while (nodes.size() != 0) {
            visit(nodes.pop());
        }
    }


    public List<Node> getBFS (Node node) {
        List<Node> nodes = new ArrayList<>();
        int pos = 0;
        if (root == null) {
            return null;
        }
        if (node == null) node = root;
        nodes.add(node);

        while (pos < nodes.size()) {
            visit(nodes.get(pos));
            if (nodes.get(pos).left != null) {
                nodes.add(nodes.get(pos).left);
            }
            if (nodes.get(pos).right != null) {
                nodes.add(nodes.get(pos).right);
            }
            pos++;
        }
        return nodes;
    }

    public void visit(Node n) {
        System.out.println(n.data);
    }
}

class Node {
    int data;
    Node left;
    Node right;
    Node parent;

    public Node(int data) {
        this.data = data;
    }


}
