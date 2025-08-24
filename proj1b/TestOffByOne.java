import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testOffByOne(){
        OffByOne obo=new OffByOne();
        // biodirectional test
        assertTrue(obo.equalChars('a', 'b'));
        assertTrue(obo.equalChars('b', 'a'));
        // common char test
        assertFalse(obo.equalChars('a', 'e'));
        // non char test
        assertFalse(obo.equalChars('r', ' '));
        assertFalse(obo.equalChars(' ', ' '));
        // upper char test
        assertFalse(obo.equalChars('Z', 'A'));
        assertTrue(obo.equalChars('B', 'A'));
        assertTrue(obo.equalChars('A','B'));
        // lower char and upper char test
        assertFalse(obo.equalChars('B', 'a'));
        // same char test
        assertFalse(obo.equalChars('a', 'a'));
        // general char test
        assertTrue(obo.equalChars('&', '%'));
    }
}
