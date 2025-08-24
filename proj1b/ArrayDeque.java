public class ArrayDeque<Item> implements Deque<Item>{
    private Item[] array;
    private int size;
    private int capacity;
    private int curhead;
    private int curtail;
    public ArrayDeque(){
        array = (Item[])new Object[8];
        size = 0;
        capacity = 8;
        curhead = 0;
        curtail = 0;
    }
    private void resize() {
        if ((double)size /capacity < 0.25 && capacity >= 16){
            Item[] newitem = (Item[])new Object[capacity];
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
            Item[] newitem = (Item[])new Object[capacity*2];
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
    @Override
    public Item get(int index){
        return array[(curhead+index)%capacity];
    }
    @Override
    public Item removeLast(){
        if (isEmpty()){
            return null;
        }
        Item res = array[curtail];
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
    @Override
    public Item removeFirst(){
        if (isEmpty()){
            return null;
        }
        size--;
        Item res = array[curhead];
        array[curhead]=null;
        curhead = (curhead+1)%capacity;
        resize();
        return res;
    }
    @Override
    public void printDeque(){
       int temp = curhead;
       while(temp != curtail){
           System.out.println(array[temp]);
           System.out.println(" ");
           temp=(temp+1)%capacity;
       }
       System.out.println(array[temp]);
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public boolean isEmpty(){
        return size==0;
    }
    @Override
    public void addLast(Item item){
        if (isEmpty()){
            array[curtail]=item;
            curhead=curtail;
        }else {
            resize();
            curtail = (curtail + 1) % capacity;
            array[curtail] = item;
        }
        size++;
    }
    @Override
    public void addFirst(Item item){
        if (isEmpty()){
            array[curhead]=item;
            curtail=curhead;
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