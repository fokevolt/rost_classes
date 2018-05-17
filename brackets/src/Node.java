public class Node<U> {
    private U value;
    private Node<U> nextNode;

    public U getValue() {
        return value;
    }

    public Node<U> getNextNode() {
        return nextNode;
    }

    Node(U value, Node<U> nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }
}
