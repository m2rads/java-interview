package bby.data.structures;

public class Queue<T> {
    public Node<T> front;
    public Node<T> back;
    public int size;

    public Queue() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    public void enqueue(T data) {
        if (size == 0) {
            this.front = new Node<T>(data);
            this.back = this.front;
        } else {
            this.back.next = new Node<T>(data);
            this.back = this.back.next;
        }
        size++;
    }

    public T dequeue() {
        if (this.size == 1) {
            this.back = null;
        }
        if (this.size != 0) {
            T data = this.front.data;
            this.front = this.front.next;
            size--;
            return data;
        }
        return null;
    }
}
