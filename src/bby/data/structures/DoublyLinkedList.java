package bby.data.structures;

import java.nio.file.Paths;

public class DoublyLinkedList<T> {

    Node<T> head;

    DoublyLinkedList() {
        this.head = null;
    }

    public void append(T data) {
        Node<T> newNode = new Node<T>(data);

        if (this.head == null) {
            this.head = newNode;
            return;
        }

        Node<T> current = this.head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        newNode.prev = current;

    }

    public void appendRecursive(T data) {
        Node<T> newNode = new Node<T>(data);

        if (this.head == null) {
            this.head = newNode;
            return;
        }

        this._appendRecursive(data, newNode, this.head);
    }

    private void _appendRecursive(T data, Node<T> newNode, Node<T> current) {
        if (current.next == null) {
            current.next = newNode;
            newNode.prev = current;
            return;
        }

        _appendRecursive(data, newNode, current.next);
    }

    public void delete(T target) {
        Node<T> current = this.head;

        while (current != null) {
            if (current.data.equals(target)) {
                // if the first node
                if (current.prev == null) {
                    this.head = current.next;
                    // cleanup
                    if (this.head != null) {
                        this.head.prev = null;
                    }
                }

                // Middle or Tail
                else {
                    current.prev.next = current.next;
                    // if middle
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    }
                }
                return;
            }

            current = current.next;
        }
    }

    public void deleteRecursive(T target) {
        _deleteRecursive(target, this.head);
    }

    private void _deleteRecursive(T target, Node<T> current) {

        if (current.data.equals(target)) {
            if (current.prev == null) {
                this.head = current.next;
                if (this.head != null) {
                    this.head.prev = null;
                }
            } else {
                current.prev.next = current.next;
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
            }

            return;
        }

        _deleteRecursive(target, current.next);
    }

    public Boolean contains(T target) {
        Node<T> current = this.head;
        while (current != null) {
            if (current.data.equals(target)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public Boolean containsRecursive(T target) {
        return _containsRecursive(target, this.head);
    }

    private Boolean _containsRecursive(T target, Node<T> current) {
        if (current == null) {
            return false;
        }

        if (current.data.equals(target)) {
            return true;
        }

        return _containsRecursive(target, current.next);
    }

    public void printList() {
        StringBuilder result = new StringBuilder();
        Node<T> current = this.head;

        while (current != null) {
            if (current.next == null) {
                result.append(current.data);
                break;
            }

            result.append(current.data).append(" <=> ");
            current = current.next;
        }

        System.out.println(result);
    }

    public void recursivePrintList() {
        StringBuffer result = new StringBuffer();
        this._recursivePrintList(this.head, result);
        System.out.println(result);
    }

    private void _recursivePrintList(Node<T> current, StringBuffer result) {
        if (current == null) {
            return;
        }
        if (current.next == null) {
            result.append(current.data);
            return;
        }

        result.append(current.data).append(" <=> ");
        _recursivePrintList(current.next, result);
    }

    public static void main(String[] args) {

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.printList();

        Node<Integer> curr = list.head.next;
        Node<Integer> prev = curr.prev;
        System.out.println(curr.data);
        System.out.println(prev.data);

        /* Recursive append tests */
        System.out.println(" **** Recursive append tests **** ");
        DoublyLinkedList<Integer> newList = new DoublyLinkedList<>();
        newList.appendRecursive(1);
        newList.appendRecursive(2);
        newList.appendRecursive(3);
        newList.appendRecursive(4);
        newList.recursivePrintList();

        /* Contains Test */
        System.out.println(" **** Contains tests **** ");
        Boolean result = newList.contains(8);
        System.out.println(result);
        result = newList.contains(4);
        System.out.println(result);

        /* Contains Recursive Test */
        System.out.println(" **** Contains tests **** ");
        Boolean recREsult = newList.containsRecursive(8);
        System.out.println(recREsult);
        recREsult = newList.containsRecursive(4);
        System.out.println(recREsult);

        /* Deletion Test */
        System.out.println(" **** Deletion tests **** ");
        newList.delete(3);
        newList.delete(1);
        newList.delete(2);
        newList.delete(4);
        newList.recursivePrintList();

        /* Recursive Deletion Test */
        System.out.println(" **** Recursive Deletion tests **** ");
        newList.appendRecursive(1);
        newList.appendRecursive(2);
        newList.appendRecursive(3);
        newList.appendRecursive(4);

        newList.deleteRecursive(3);
        newList.deleteRecursive(1);
        newList.recursivePrintList();

        newList.deleteRecursive(2);
        newList.deleteRecursive(4);
        newList.recursivePrintList();

    }


}
