class MyHashMap {
    private static class Node {
        int key;
        int val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int SIZE = 1000;
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    // Helper method to find the node previous to the node with the given key
    private Node findPrev(Node head, int key) {
        Node curr = head;
        Node prev = null;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (buckets[index] == null) {
            // Create a dummy head node for easier insertion and deletion
            buckets[index] = new Node(-1, -1);
        }

        Node prev = findPrev(buckets[index], key);
        if (prev.next == null) {
            // Key does not exist, insert new node at the end
            prev.next = new Node(key, value);
        } else {
            // Key already exists, update value
            prev.next.val = value;
        }
    }

    public int get(int key) {
        int index = hash(key);
        if (buckets[index] == null) {
            return -1;
        }

        Node prev = findPrev(buckets[index], key);
        if (prev.next == null) {
            return -1;
        }
        return prev.next.val;
    }

    public void remove(int key) {
        int index = hash(key);
        if (buckets[index] == null) {
            return;
        }

        Node prev = findPrev(buckets[index], key);
        if (prev.next != null) {
            // Remove node by skipping it
            prev.next = prev.next.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */