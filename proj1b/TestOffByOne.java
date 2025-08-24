import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testOffByOne(){
        // biodirectional test
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('b', 'a'));
        // common char test
        assertFalse(offByOne.equalChars('a', 'e'));
        // non char test
        assertFalse(offByOne.equalChars('r', ' '));
        assertFalse(offByOne.equalChars(' ', ' '));
        // upper char test
        assertFalse(offByOne.equalChars('Z', 'A'));
        assertTrue(offByOne.equalChars('B', 'A'));
        assertTrue(offByOne.equalChars('A','B'));
        // lower char and upper char test
        assertFalse(offByOne.equalChars('B', 'a'));
        // same char test
        assertFalse(offByOne.equalChars('a', 'a'));
        // general char test
        assertTrue(offByOne.equalChars('&', '%'));
    }
}
