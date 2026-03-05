package bby.data.structures;

public class DoublyLinkedList<T> {

    Node<T> head;

    DoublyLinkedList() {
        this.head = null;
    }

    public void append(T data) {
        Node<T> newNode = new Node<T>(data);

        if (this.head == null) {
            this.head = new Node<T>(data);
            return;
        }

        Node<T> current = this.head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        newNode.prev = current;

    }




}
