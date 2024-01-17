package Problem1119;
import java.util.*;

public class removeVowels {
     /*
      Problem #1119 on leetcode.com:
      
      Given a string S, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new string.

      Example 1:
      Input: "This is a test."
      Output: "Ths s  tst."

      Example 2:
      Input: "leetcodeisacommunityforcoders"
      Output: "ltcdscmmntyfrcdrs"

      Example 3:
      Input: "aeiou"
      Output: ""
     */

    public static StringBuffer checkVowels (StringBuffer s) {

      for(int i=0; i<s.length(); i++){

        char myChar = s.charAt(i);
        //convert to String for equalsIgnoreCase
        String letter = String.valueOf(myChar);

        if( letter.equalsIgnoreCase("A") || letter.equalsIgnoreCase("E")
        || letter.equalsIgnoreCase("I") || letter.equalsIgnoreCase("O")
        || letter.equalsIgnoreCase("U")) {
          //if vowel of any case, then remove vowel from the string at the index
          s.deleteCharAt(i);
          //this accounts for vowels next to each other because deleting char would result in -1 lenght, shifts everything down 1 index
          i--; 
        }
      }
      return s;
    }
    
    public static void main (String arg[]) {
      //data needed
      Scanner input = new Scanner(System.in);
      
      //prompt
      System.out.println("Give a string:");
      StringBuffer sentence = new StringBuffer(input.nextLine());
      input.close();
      System.out.println(checkVowels(sentence));  
    }
}
