package questions;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node (int key, int val) {
            this.key = key;
            this.value = val;
        }
    }

    private int capacity;
    private Map<Integer, Node> mp;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.mp = new HashMap<>();
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        Node node = mp.getOrDefault(key, null);

        if (node == null) {
            return -1;
        }

        if (node != null) {
            if (node == head) {
                return node.value;
            }
            removeNodeaFromLinkedList(node);
            addNodeToHead(node);

        }

        return node.value;
    }
    

    public void put(int key, int value) {
        Node node = mp.getOrDefault(key, null);

        if (node == null) {
            Node newNode = new Node(key,value);
            mp.put(key, newNode);
            addNodeToHead(newNode);
        } else {
            removeNodeaFromLinkedList(node);
            node.value = value;
            addNodeToHead(node);
        }
        
    }

    private void addNodeToHead(LRUCache.Node node) {

        if (head == null || tail == null) {
            head = node;
            tail = node;
            return;
        }

        node.next = head;
        head.prev = node;
        node.prev = null;
        head = node;


        if (capacity < mp.size()) {
            if (tail != null) {
                mp.remove(tail.key);
                Node temp = tail.prev;
                tail.prev = null;
                tail = temp;
            }
        }

        if (tail != null) {
            tail.next = null;
        }
    }


    private void removeNodeaFromLinkedList(LRUCache.Node node) {
        
        if (node.next == null) {
            tail = node.prev;
        } else {
            node.next.prev = node.prev;
        }

        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }

        node.next = null;
        node.prev = null;
    
        if (head != null) {
            head.prev = null;
        }

        if (tail != null) {
            tail.next = null;
        }

    }



    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.err.println(lruCache.get(2));
    }


    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */