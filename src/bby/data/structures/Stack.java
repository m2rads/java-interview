package bby.data.structures;

public class Stack<T> {
    public Node<T> top;
    public int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public void push(T data) {
        if (this.size == 0) {
            this.top = new Node<T>(data);
        } else {
            Node<T> pushedNode = new Node<>(data);
            pushedNode.next = this. top;
            this.top = pushedNode;
        }
        this.size++;
    }

    public T pop() {
        if (this.size == 0) {
            return null;
        }
        T data = this.top.data;
        this.top = this.top.next;
        this.size--;
        return data;
    }
}
