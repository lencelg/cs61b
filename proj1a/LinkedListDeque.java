public class LinkedListDeque<T>{
    private class Node{
        public T data;
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
    public void addFirst(T item){
        boolean flag= head == null;
        Node newnode = new Node();
        newnode.data = item;
        newnode.prev = null;
        newnode.next = head;
        head = newnode;
        size++;
        if (flag){
            tail = head;
        }
    }
    public void addLast(T item){
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
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        Node temp = head;
        while(temp.next != null){
            System.out.println(temp.data);
            System.out.println(" ");
            temp=temp.next;
        }
        System.out.println((temp.data));
    }
    public T removeFirst(){
        if (head == null){
            return null;
        }
        T res = head.data;
        head = head.next;
        size--;
        return res;
    }
    public T removeLast(){
        if (tail == null){
            return null;
        }
        Node temp = tail;
        T res = temp.data;
        tail = tail.prev;
        temp = null;
        size--;
        return res;
    }
    public T get(int index){
        Node temp = head;
        for (int i = 0;i < index;i++){
            temp = temp.next;
        }
        return temp.data;
    }
    public T getRecursive(int index){
        return getRecursive(head,index);
    }
    private T getRecursive(Node head,int index){
        if(index == 0){
            return head.data;
        }
        return getRecursive(head.next,--index);
    }
}