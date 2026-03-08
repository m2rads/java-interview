package bby.data.structures;


import java.util.HashMap;

public class LRU<T> {

    static class Node<T> {
        int key;
        int data;
        Node<T> prev;
        Node<T> next;

        public Node(int key, int data) {
            this.key = key;
            this.data = data;
        }
    }

    HashMap<Integer, Node<T>> map;
    Node<T> head, tail;
    int capacity;

    public LRU(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        this.head = new Node<>(0, 0);
        this.tail = new Node<>(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node<T> node = map.get(key);
        remove(node);
        addToFront(node);
        return node.data;
    }

    public void put(int key, int data) {
        if (map.containsKey(key)) {
            Node<T> node = map.get(key);
            node.data = data;
            remove(node);
            addToFront(node);
        } else {
            if (map.size() == capacity) {
                Node<T> lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }

            Node<T> node = new Node<>(key, data);
            map.put(key, node);
            addToFront(node);
        }
    }

    private void remove(Node<T> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToFront(Node<T> node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
