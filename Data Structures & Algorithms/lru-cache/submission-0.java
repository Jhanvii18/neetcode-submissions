class Node
{
    int key;
    int value;
    Node next;
    Node prev;
    Node(int key,int value)
    {
        this.key=key;
        this.value=value;
        this.next=null;
        this.prev = null;
    }
}
class LRUCache 
{
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int cap=0;
    Map<Integer,Node> map = new HashMap<>();//map stores the address of the node thus direct access
    public LRUCache(int capacity) 
    {
        cap=capacity;
        head.next = tail;
        tail.prev = head;
    }
    void delete(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    void insert(Node node)
    {
        node.prev=head;
        head.next.prev=node;
        node.next=head.next;
        head.next=node;
    }
    public int get(int key) 
    {
        if(!map.containsKey(key))
        return -1;

        else
        {
            Node node = map.get(key);
            delete(node);
            insert(node);
            return node.value;
        }
    }
    public void put(int key, int value) 
    {
        if(map.containsKey(key))
        {
            delete(map.get(key));
            map.remove(key);
        }
        Node node = new Node(key,value);
        insert(node);
        map.put(key,node);
        if(map.size()>cap)
        {
            Node lru = tail.prev;
            delete(lru);
            map.remove(lru.key);
        }
    }
}
