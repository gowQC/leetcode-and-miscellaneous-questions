package Problem6;
import java.util.*;

public class zigzag {
     /*
        This is a modified version of Problem 6. This modified version makes the string more appealing and gives it more detail
        in the spacing.

        For X rows, we need to print X-2 letters as the diagonal letters.
        To make zigzags, make no letter share the same column.

        PAYPALISHIRING with 1 rows =
            PAYPALISHIRING     //no spaces
        
        PAYPALISHIRING with 2 rows =
            P Y A I H R N      //3 spaces apart from each other
             A P L S I I G     //1 space apart from each other

        PAYPALISHIRING with 3 rows =
            P   A   H   N      //3 spaces apart from each other
             A P L S I I G     //1 space apart from each other
              Y   I   R        //3 spaces apart from each other
              
        PAYPALISHIRING  with 4 rows =
            P     I     N      //5 spaces apart from each other
             A   L S   I G     //3 and then 1 spaces apart from each other
              Y A   H R        //1 and then 3 spaces apart from each other
               P     I         //5 spaces apart from each other
               
        PAYPALISHIRING  with 5 rows =
            P       H          //7 spaces apart from each other
             A     S I         //5 and then 1 spaces apart from each other
              Y   I   R        //3 and then 3 spaces apart from each other
               P L     I G     //1 and then 5 spaces apart from each other
                A       N      //7 spaces apart from each other
        
        PAYPALISHIRINGGG  with 6 rows =
            P         R        //9 spaces apart from each other
             A       I I       //7 and then 1 spaces apart from each other
              Y     H   N      //5 and then 3 spaces apart from each other
               P   S     G     //3 and then 5 spaces apart from each other
                A I       G    //1 and then 7 spaces apart from each other
                 L         G   //9 spaces apart from each other

        *Initial spaces of each row are not counted.
    */
    
    public static String convert(String s, int numRows) {

        String output = "";

        //base case: numRows = 1 or numRows = 2
        if (numRows == 1) {
            System.out.println(s);
            output = s;
        }

        else if(numRows == 2) {
            for(int i=0; i<s.length();i+=2) {
                System.out.print(s.charAt(i));
                output = output + s.charAt(i);
                System.out.print(" ");
            }
            System.out.println();
            System.out.print(" ");
            for(int i=1; i<s.length();i+=2) {
                System.out.print(s.charAt(i));
                output = output + s.charAt(i);
                System.out.print(" ");
            }
        }

        //numRows > 2
        else if(numRows > 2) {

            int diagonalRows = numRows - 2; //int records # of rows in between top/bottom rows
            int spaces = numRows + (numRows - 3); //spaces between top and bottom row elements
            int total = diagonalRows + numRows; //used to print next element in top and bottom rows

            int high = spaces -2;
            int low = 1;

            //print first row
            for(int i=0; i<s.length(); i+=total ) {
                System.out.print(s.charAt(i));
                output = output + s.charAt(i);
                for(int j=0; j<spaces; j++) {
                    System.out.print(" "); //print spaces
                }
            }
            System.out.println();
            
            //print middle rows
            for(int i=1; i<numRows-1; i++) { //targets each middle row

                int counter = 0;
                int k=i;

                while(counter < i){ //initial spaces per row
                    System.out.print(" ");
                    counter++;
                } 

                //print elements
                while(k<s.length()){
                    System.out.print(s.charAt(k));
                    output = output + s.charAt(k);
                    for(int x=0;x<high;x++) { //prints out high number of spaces in the row
                        System.out.print(" ");
                        k++;
                    }
                    k++;
                    if(k>=s.length()){ //break to prevent indexoutofbounds error
                        break;
                    }
                    System.out.print(s.charAt(k));
                    output = output + s.charAt(k);
                    for(int x=0;x<low;x++) {//prints out low number of spaces in the 
                        System.out.print(" ");
                        k++;
                    }
                    k++;
                }

                System.out.println();
                counter=0;
                high=high-2;
                low=low+2;
            }
            
            //print last row

            //last row's initial spaces
            for(int i=0;i<numRows-1;i++) {
                System.out.print(" ");
            }

            //main contents of last row
            for(int i=numRows-1; i<s.length(); i+=total ){   
                System.out.print(s.charAt(i));
                output = output + s.charAt(i);
                for(int j=0; j<spaces; j++) {
                    System.out.print(" "); //print spaces
                }
            }
        }   
        System.out.println();
        return output;     
    }

    public static void main (String arg[])
  {
    //data needed
    Scanner input = new Scanner(System.in);
    
    //prompt
    System.out.println("Give a string:");
    String sentence = input.nextLine();
    System.out.println("Give number of desired rows:");
    int rows = input.nextInt();
    input.close();
    System.out.print(convert(sentence, rows));
  }
}