package synthesizer;
import edu.princeton.cs.algs4.In;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(5);

    }
    @Test
    public  void personaltest(){
        BoundedQueue<Integer> x = new ArrayRingBuffer(5);
        assertEquals(null,x.peek());
        x.enqueue(1);
        x.enqueue(2);
        x.enqueue(3);
        x.enqueue(4);
        x.enqueue(5);
        assertEquals((Integer) 1,x.dequeue());
        assertEquals((Integer) 2,x.peek());
        assertEquals((Integer) 2,x.dequeue());
        assertEquals((Integer) 3,x.dequeue());
        x.dequeue();
        x.dequeue();
        assertEquals(null,x.peek());
        x.enqueue(1);
        assertEquals((Integer) 1 , x.dequeue());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
