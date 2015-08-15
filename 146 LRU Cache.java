public class LRUCache {
    class Node {
        int val;
        int key;
        Node next;
        Node pre;
        public Node(int key, int val) {
            this.val = val;
            this.key = key;
            next = null;
            pre = null;
        }
        public Node(int i) {
            this.val = i;
            this.key = i;
            next = null;
            pre = null;
        }
    }
    Node head;
    Node tail;
    int count;
    int capacity;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.next = head.next;
            node.pre = head;
            head.next = node;
            node.next.pre = node;
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.next = head.next;
            node.pre = head;
            head.next = node;
            node.next.pre = node;
            node.val = value;
        } else {
            if (count == capacity) {
                Node lru = tail.pre;
                map.remove(lru.key);
                lru.pre.next = tail;
                tail.pre = lru.pre;
                count--;
            }
            Node node = new Node(key, value);
            map.put(key, node);
            head.next.pre = node;
            node.next = head.next;
            head.next = node;
            node.pre = head;
            count++;
        }
    }
}
