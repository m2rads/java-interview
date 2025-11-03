package bby.data.structures;

public class LinkedList<T> {
    Node<T> head;

    public LinkedList()  {
        this.head = null;
    }

    public void append(T data) {
        if (this.head == null) {
            this.head = new Node<T>(data);
        }

        else {
            Node<T> current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<T>(data);
        }
    }

    public void printList() {
        StringBuilder text = new StringBuilder();
        Node<T> current = this.head;
        while (current != null) {
            text.append(current.data).append(" -> ");
            current = current.next;
        }
        System.out.println(text);
    }

    public Boolean contains(T target) {
        Node<T> current = this.head;
        while (current != null ) {
            if (current.data.equals(target)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void reverse() {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    } // O(n) time and O(1) space

    public void recursionReverse() {
        Node<T> current = head;
        _recursionReverse(current, null);
    }

    private void _recursionReverse(Node<T> current, Node<T> prev) {
        if (current == null) {
            head = prev;
            return;
        }
        Node<T> next = current.next;
        current.next = prev;
        _recursionReverse(next, current);
    } // O(n) time and O(n) space due to call stack
}
