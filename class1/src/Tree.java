import java.util.ArrayList;
import java.util.List;

class Tree<T extends Comparable<T>> {

    private Node head = null;

    public void add(int item){
        Node current = new Node(item);
        if (isEmpty()) {
            head = current;
        }
        else
            head.addNode(current);
    }

    public boolean isEmpty(){
        return (head == null);
    }

    public boolean contains(int item){
        if (isEmpty()) return false;
        return (head.findNode(new Node(item)));
    }

    public List<Node> getElements(){
        List<Node> elements = new ArrayList<>();
        head.getNodes(elements);
        return elements;
    }
}

interface Comparable<T> {
    CompareResult compare(T other);
}

enum CompareResult{
    GREATER_THEN, EQUALS, LESS_THEN
}
class Node implements Comparable<Node> {
    private int value;
    private Node left;
    private Node right;

    Node(int value){
        this.value = value;
        left = null;
        right = null;
    }

    public int getValue() {
        return value;
    }

    public void addNode(Node current) {
        switch (current.compare(this)) {
            case LESS_THEN:
                if (left != null) {
                    left.addNode(current);
                } else left = current;
                break;
            case GREATER_THEN:
                if (right != null) {
                    right.addNode(current);
                } else right = current;
                break;
            default:
                throw new IllegalArgumentException("The item is already exists");
        }
    }

    public boolean findNode(Node current) {
        switch (current.compare(this)) {
            case LESS_THEN:
                if (left != null) {
                    return left.findNode(current);
                }
                else return false;
            case GREATER_THEN:
                if (right != null) {
                    return right.findNode(current);
                }
                else return false;
            default:
                return true;
        }
    }

    public void getNodes(List<Node> nodes) {
        if (this.left != null) this.left.getNodes(nodes);
        nodes.add(this);
        if (this.right != null) this.right.getNodes(nodes);
    }

    @Override
    public CompareResult compare(Node other) {
        if (value > other.value) return CompareResult.GREATER_THEN;
        if (value < other.value) return CompareResult.LESS_THEN;
        return CompareResult.EQUALS;
    }
}
