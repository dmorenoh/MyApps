package hello;

import java.util.Arrays;

/**
 * Created by dmorenoh on 19/3/16.
 */
public class AppMain {
    public static void main(String[] args) {
        /*String str = "www.journaldev.com";
        System.out.println("Last 4 chars:" + str.subSequence(str.length()-4,str.length() ) );
        System.out.println("Last 4 chars:" + str.substring(str.length()-4) );
        String str2 = "ABC";
        System.out.println(str2.compareTo("ABD"));
        System.out.println(str2.compareToIgnoreCase("abc"));*/

        /*
        String str = "123";
        char[] chArr = str.toCharArray();
        System.out.println("String to char array: "+ Arrays.toString(chArr));
        char c = str.charAt(1);
        System.out.println("String to char: "+c);
        String s = Character.toString(c);
        System.out.println("char to String: "+s);
        System.out.println("removing all chars from String: "+ removeCharFromString("1ABCD12DW", '1'));
*/
        String str = "www.journaldev.com";
        byte[] bytes =str.getBytes();
        System.out.print("String to bytes" + Arrays.toString(bytes));
        String byteToString = new String(bytes);
        System.out.print("Bytes to String" + byteToString);
        System.out.println("str == str1? " + (str == byteToString));
        System.out.println("str.equals(str1)? " + (str.equals(byteToString)));
    }



    public static String removeCharFromString (String string, char c) {
        if (string==null)
            return null;
        return string.replaceAll(Character.toString(c),"");
    }
}