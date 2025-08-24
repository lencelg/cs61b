import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("racecar"));
        // test for overload Palindrome
        CharacterComparator cc = new OffByOne();
        assertFalse(palindrome.isPalindrome("cat",cc));
        assertTrue(palindrome.isPalindrome("cab",cc));
        assertTrue(palindrome.isPalindrome("",cc));
        assertTrue(palindrome.isPalindrome("a",cc));
        assertFalse(palindrome.isPalindrome("cbbc",cc));
        assertTrue(palindrome.isPalindrome("ccbd",cc));
        assertFalse(palindrome.isPalindrome("ccbD",cc));
    }
}
