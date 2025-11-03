// add a package declaration if needed
package bby.data.structures;

public class Node<T> {
    public T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
