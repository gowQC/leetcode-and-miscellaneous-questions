/*
*The objective is to take a given string from the user and print out the given string without any vowels.
*
*Input: "This is a test."
*Output: "Ths s  tst."
*
*The i's, the e, and the a have been removed from the string in the output.
*
*/
import java.util.*;

public class removeVowels
{
  public static StringBuffer checkVowels(StringBuffer s)
  {
    for (int i=0; i<s.length(); i++)
    {
      char letter = s.charAt(i);
      
      if(letter == 'a' || letter == 'e' ||letter == 'i' ||letter == 'o' ||letter == 'u')
      {
        //if vowel, then remove vowel from the string at the index
        s.deleteCharAt(i);
      }
    }
    return s;
  }
  
  public static void main (String arg[])
  {
    //data needed
    Scanner input = new Scanner(System.in);
    
    //prompt
    System.out.println("Give a string:);
    StringBuffer sentence = new StringBuffer(input.nextLine());
    input.close();
    System.out.println(checkVowels(sentence));  
  }
}
