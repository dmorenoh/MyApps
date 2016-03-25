package hello;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dmorenoh on 19/3/16.
 */
public class UtilsTest {

    Utils utils = new Utils();

    @Test
    public void compareString_haveDifferentChars_returnFalse () {
        String str1 = "ABC";
        String str2 = "CDE";
        assertFalse(utils.compareEquals(str1,str2));

    }

    @Test
    public void compareString_haveSameChars_returnTrue () {
        String str1 = "abcda";
        String str2 = "adcba";
        assertTrue(utils.compareEquals(str1,str2));

    }

    @Test
    public void checkPalindrome_notPalidrom_returnFalse () {
        String notPalindrome = "abcde";
        assertFalse(utils.checkPalindrome(notPalindrome));
    }

    @Test
    public void checkPalindrome_palidrom_returnTrue () {
        String notPalindrome = "abcba";
        assertTrue(utils.checkPalindrome(notPalindrome));
    }

    @Test
    public void checkPalindromeLong_notPalidrom_returnFalse () {
        String notPalindrome = "abcde";
        assertFalse(utils.checkPalindromeLong(notPalindrome));
    }

    @Test
    public void checkPalindromeLong_palidrom_returnTrue () {
        String notPalindrome = "abcdcba";
        assertTrue(utils.checkPalindromeLong(notPalindrome));
    }

    @Test
    public void removeCharactrer_removing () {
        String toRemoveChar = "abs1sdfs1ssd1";
        String expected = "abssdfsssd";
        assertEquals(expected, utils.removeCharacter(toRemoveChar, '1'));
    }

    @Test
    public void countPalindrome_wordWithPalindromes_returnPalindromeAmmount () {
        String str = "barbarabar";
        assertEquals(7, utils.getPalindromeWordAmmount(str));
    }

    @Test
    public void largestPalindrome_notPalindrome_returnNull () {
        String str = "abc";
        assertNull(utils.getLargestPalindrome(str));
    }

    @Test
    public void largestPalindrome_withPalindrome_returnLargest () {
        String str = "9912321456";
        assertEquals("12321",utils.getLargestPalindrome(str));
    }
}