public class ArrayDeque<T>{
    private T[] array;
    private int size;
    private int capacity;
    private int curhead;
    private int curtail;
    public ArrayDeque(){
        array = (T [])new Object[8];
        size = 0;
        capacity = 8;
        curhead = 0;
        curtail = 0;
    }
    private void resize() {
        if ((double)size /capacity < 0.25 && capacity >= 16){
            T[] newitem = (T [])new Object[capacity];
            for (int i = curhead,j = 0;j < size;j++){
                newitem[j] = array[i];
                i = (i+1)%capacity;
            }
            capacity = capacity/2;
            newitem[size-1] = array[curtail];
            array = newitem;
            curhead=0;
            curtail=size-1;
            return;
        }
        if(size+1 > capacity){
            T[] newitem = (T [])new Object[capacity*2];
            for (int i = curhead,j = 0; j < size ;j++){
                newitem[j] = array[i];
                i=(i+1)%capacity;

            }
            capacity = capacity*2;
            newitem[size-1] = array[curtail];
            array = newitem;
            curhead=0;
            curtail=size-1;
            return;
        }
    }
    public T get(int index){
        return array[(curhead+index)%capacity];
    }
    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        T res = array[curtail];
        if(curtail == 0){
            curtail = capacity-1;
        }else if (curhead == curtail){
           // case for size==1 , do nothing
        }else {
            curtail = (curtail - 1) % capacity;
        }
        size--;
        resize();
        return res;
    }
    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        size--;
        T res = array[curhead];
        array[curhead]=null;
        curhead = (curhead+1)%capacity;
        resize();
        return res;
    }
    public void printDeque(){
       int temp = curhead;
       while(temp != curtail){
           System.out.println(array[temp]);
           System.out.println(" ");
           temp=(temp+1)%capacity;
       }
       System.out.println(array[temp]);
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void addLast(T item){
        resize();
        curtail=(curtail+1)%capacity;
        array[curtail] = item;
        size++;
    }
    public void addFirst(T item){
        if (isEmpty()){
            array[curhead]=item;
        }else {
            resize();
            if (curhead == 0 ){
                curhead = capacity-1;
            }else {
                curhead = (curhead - 1) % capacity;
            }
            array[curhead] = item;
        }
        size++;
    }
}