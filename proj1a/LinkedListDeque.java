
public class LinkedListDeque<T> {

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
            return;
        }
        head.next.prev=head;
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
        size--;
        T res = head.data;
        head = head.next;
        if (size == 0){
            tail = head;
            return res;
        }
        head.prev=null;
        return res;
    }
    public T removeLast(){
        if (tail == null){
            return null;
        }
        size--;
        T res = tail.data;
        tail = tail.prev;
        if (size==0){
            head=tail;
            return res;
        }
        tail.next=null;
        return res;
    }
    public T get(int index){
        if (index<0 || index>size){
            return null;
        }
        Node temp = head;
        for (int i = 0;i < index;i++){
            temp = temp.next;
        }
        return temp.data;
    }
    public T getRecursive(int index){
        if (index<0 || index>size){
            return null;
        }
        return getRecursive(head,index);
    }
    private T getRecursive(Node head,int index){
        if(index == 0){
            return head.data;
        }
        return getRecursive(head.next,index-1);
    }
}
