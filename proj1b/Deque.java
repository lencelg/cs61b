public interface Deque<Item>{
    public Item get(int index);
    public Item removeLast();
    public Item removeFirst();
    public void printDeque();
    public int size();
    public boolean isEmpty();
    public void addLast(Item item);
    public void addFirst(Item item);

}