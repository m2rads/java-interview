package bby.data.structures;


import java.util.*;

class LFUCache {
    static class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    static class DLList {
        Node head, tail;
        int size;

        DLList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void add(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size > 0) {
                Node node = tail.prev;
                remove(node);
                return node;
            }
            return null;
        }
    }

    private int capacity, minFreq;
    private HashMap<Integer, Node> keyToNode;
    private HashMap<Integer, DLList> freqToList;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToNode = new HashMap<>();
        this.freqToList = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1;
        }

        Node node = keyToNode.get(key);
        updateFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.value = value;
            updateFreq(node);
        } else {
            if (keyToNode.size() == capacity) {
                // Remove LFU item
                DLList minFreqList = freqToList.get(minFreq);
                Node toRemove = minFreqList.removeLast();
                keyToNode.remove(toRemove.key);
            }

            Node newNode = new Node(key, value);
            keyToNode.put(key, newNode);
            minFreq = 1;
            freqToList.putIfAbsent(1, new DLList());
            freqToList.get(1).add(newNode);
        }
    }

    private void updateFreq(Node node) {
        int freq = node.freq;
        DLList list = freqToList.get(freq);
        list.remove(node);

        if (freq == minFreq && list.size == 0) {
            minFreq++;
        }

        node.freq++;
        freqToList.putIfAbsent(node.freq, new DLList());
        freqToList.get(node.freq).add(node);
    }
}
