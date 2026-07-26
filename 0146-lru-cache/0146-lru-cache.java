class LRUCache {
    private static class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(){
            this(0,0);
        }
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    private final int capacity;
    private final Map<Integer,Node> cache;
    private final Node head;
    private final Node tail;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.cache=new HashMap<>();
        this.head=new Node();
        this.tail=new Node();
        this.head.next=this.tail;
        this.tail.prev=this.head;
    }
    
    public int get(int key) {
        Node node=cache.get(key);
        if(node==null)return -1;
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        if(node != null){
            node.value=value;
            moveToHead(node);
        } else {
            Node newNode=new Node(key,value);
            cache.put(key,newNode);
            addToHead(newNode);
            if(cache.size()>capacity){
                Node tailNode=popTail();
                cache.remove(tailNode.key);
            }
        }
    }
    private void addToHead(Node node){
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
    }
    private void removeNode(Node node){
        Node prevNode=node.prev;
        Node nextNode=node.next;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
    }
    private void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }
    private Node popTail(){
        Node res=tail.prev;
        removeNode(res);
        return res;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */