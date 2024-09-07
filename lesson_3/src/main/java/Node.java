
public class Node<E> {
    E element;
    Node prev;
    Node next;


    public Node(E element) {
        this.element = element;
        this.prev = null;
        this.next = null;
    }
}
