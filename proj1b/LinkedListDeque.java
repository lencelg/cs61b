
public class LinkedListDeque<Item> implements Deque<Item>{

    private class Node{
        public Item data;
        public Node next;
        public Node prev;
    }
    private int size;
    private Node head;
    private Node tail;
    public LinkedListDeque(){
       size = 0;
       head = null;
       tail = null;
    }
    @Override
    public void addFirst(Item item){
        boolean flag= head == null;
        Node newnode = new Node();
        newnode.data = item;
        newnode.prev = null;
        newnode.next = head;
        head = newnode;
        size++;
        if (flag){
            tail = head;
            return;
        }
        head.next.prev=head;
    }
    @Override
    public void addLast(Item item){
        boolean flag= head == null;
        Node newnode = new Node();
        newnode.data = item;
        newnode.prev = tail;
        newnode.next = null;
        size++;
        if (flag){
            tail = newnode;
            head = tail;
            return;
        }
        tail.next = newnode;
        tail = newnode;
    }
    @Override
    public boolean isEmpty(){
        return size==0;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public void printDeque(){
        Node temp = head;
        while(temp.next != null){
            System.out.println(temp.data);
            System.out.println(" ");
            temp=temp.next;
        }
        System.out.println((temp.data));
    }
    @Override
    public Item removeFirst(){
        if (head == null){
            return null;
        }
        size--;
        Item res = head.data;
        head = head.next;
        if (size == 0){
            tail = head;
            return res;
        }
        head.prev=null;
        return res;
    }
    @Override
    public Item removeLast(){
        if (tail == null){
            return null;
        }
        size--;
        Item res = tail.data;
        tail = tail.prev;
        if (size==0){
            head=tail;
            return res;
        }
        tail.next=null;
        return res;
    }
    @Override
    public Item get(int index){
        if (index<0 || index>size){
            return null;
        }
        Node temp = head;
        for (int i = 0;i < index;i++){
            temp = temp.next;
        }
        return temp.data;
    }
    public Item getRecursive(int index){
        if (index<0 || index>size){
            return null;
        }
        return getRecursive(head,index);
    }
    private Item getRecursive(Node head, int index){
        if(index == 0){
            return head.data;
        }
        return getRecursive(head.next,index-1);
    }
}
