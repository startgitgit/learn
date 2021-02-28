package alg;

import java.util.HashMap;

public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int size;
    int capacity;
    DLinkedNode head;
    DLinkedNode tail;
    HashMap<Integer, DLinkedNode> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
    }

    public int get(int key) {
        DLinkedNode dLinkedNode = cache.get(key);
        if (dLinkedNode == null) {
            return -1;
        }
        moveToHead(dLinkedNode);
        return dLinkedNode.value;

    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private DLinkedNode removeTail() {
        DLinkedNode pre = tail.pre;
        removeNode(pre);
        return pre;
    }

    public void put(int key, int value) {
        DLinkedNode dLinkedNode = cache.get(key);
        if (dLinkedNode == null) {
            DLinkedNode dLinkedNode1 = new DLinkedNode(key, value);
            cache.put(key, dLinkedNode1);
            addToHead(dLinkedNode1);
            size++;
            if (size > capacity) {
                DLinkedNode dLinkedNode2 = removeTail();
                cache.remove(dLinkedNode2.key);
                size--;
            }
        } else {
            dLinkedNode.value = value;
            moveToHead(dLinkedNode);
        }
    }


}
