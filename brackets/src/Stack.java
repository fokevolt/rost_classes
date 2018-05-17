public class Stack<T> {
    private Node<T> head = null;

    public void push(T value) {
            head = new Node<>(value, head);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Nothing to pop!");
        }
        Node<T> nodeToPop = head;
        head = head.getNextNode();
        return nodeToPop.getValue();
    }

    public T getHead() {
        return head.getValue();
    }

    public boolean isEmpty() {
        return (head == null);
    }
}
