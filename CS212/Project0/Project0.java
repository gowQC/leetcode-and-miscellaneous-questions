import javax.swing.JOptionPane;
import java.lang.NullPointerException;

class Project0
{
    /*Name: Nicholas Osorio                                                                                                                                  
      Lab Section: F                                                                                                                                         
    */

    public static void main(String[] args)
    {
    	int e=0, E=0;
    	int loop=0;
    	char check;
    	try 
    	{
    		while(loop==0)
    		{
    			String sentence = JOptionPane.showInputDialog("Please enter a sentence: ");
    			for(int i=0;i<sentence.length();i++)
    			{
    				check = sentence.charAt(i);
    				if(check == 'e')
    					e++;
    				if(check == 'E')
    					E++;
    			}
    		JOptionPane.showMessageDialog(null, "Number of lower case e's: " + Integer.toString(e) + "\n" +
        		"Number of upper case e's: " + Integer.toString(E));
    		e=0;
    		E=0;
    		}
    	}
    	catch(NullPointerException x)
    	{
            System.out.println("Program closed.");
    		System.exit(0);
    	}
    }
}
