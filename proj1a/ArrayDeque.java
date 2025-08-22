public class ArrayDeque<T>{
    private T[] array;
    private int size;
    private int capacity;
    private int curhead;
    private int curtail;
    public ArrayDeque(){
        array =(T [])new Object[8];
        size=0;
        capacity=8;
        curhead=0;
        curtail=0;
    }
    private void resize(){
        if (size/capacity<0.25){
            capacity=capacity/2;
            T[] newitem=(T [])new Object[capacity];
            for (int i=curhead,j=0;i<size;i++,j++){
                newitem[j]= array[i];
            }
            array =newitem;
            return;
        }
        if(size+1>capacity){
            capacity=capacity*2;
            T[] newitem=(T [])new Object[capacity];
            for (int i=curhead,j=0;i<size;i++,j++){
                newitem[j]= array[i];
            }
            array =newitem;
            return;
        }
    }
    public T get(int index){return array[index];}
    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        T res= array[curtail];
        array[curtail]=null;
        curtail=(curtail-1)%capacity;
        size--;
        resize();
        return res;
    }
    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        size--;
        T res= array[curhead];
        curhead=(curhead+1)%capacity;
        resize();
        return res;
    }
    public void printDeque(){
       int temp=curhead;
       while(temp!=curtail){
           System.out.println(array[temp]);
           System.out.println(" ");
           temp=(temp+1)%capacity;
       }
       System.out.println(array[temp]);
    }
    public int size(){return size;}
    public boolean isEmpty(){return size==0;}
    public void addLast(T item){
        resize();
        array[size]=item;
        size++;
    }
    public void addFirst(T item){
        resize();
        curhead=(curhead-1)%capacity;
        array[curhead]=item;
        size++;
    }
}