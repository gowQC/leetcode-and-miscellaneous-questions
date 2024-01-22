import java.util.*;
import java.io.*;
import javax.swing.*;

class Project1
{
	/*Name: Nicholas Osorio
	 *Lab Section: F
	 */
	
	public static String compileString(Box array[], int lines) 
	{
		String boxes="";
		for(int i=0;i<lines;i++)
		{
			boxes=boxes+"<html>"+array[i].toString()+"<br/>";
		}
		return boxes;
	}
	
	public static int[] findVolumes(Box array[], int lines)
	{
		int[] send = new int [lines];
		for(int i=0;i<lines;i++)
		{
			send[i]= array[i].getLength() * array[i].getWidth() * array[i].getHeight();
		}
		return send;
	}
	
	public static void main(String[] args)
	{
		try
		{
			
			//allot data for the name of the file
			String fileName;
		
			//set up first scanner; ask for file name
			Scanner first = new Scanner(System.in);
			System.out.println("Select the file you wish to use Box data for: ");
			fileName = first.nextLine();
			first.close();

			//set up second scanner to open file
			Scanner second = new Scanner(new File(fileName));
			
			//allot space to record number of lines in the file
			int lines=0;
			
			//this will read how many lines of data there are and give "lines" a new value
			while(second.hasNext())
			{
				second.next();
				lines++;
			}
			second.close();
			
			//initialize 2 arrays based on number of lines in file
			int[] numArray = new int[lines*3]; //* 3 because there are 3 integers per Box
			Box[] boxArray = new Box[lines];
			
			//use integer "i' to keep for while loop to fill in index entries of numArray
			int i=0;

			//third scanner to rescan file for data
			Scanner third = new Scanner(new File(fileName));
			
			//while something is left in the file, the while loop will use
			//"dummy" to temporarily copy each extracted line of data and convert it to int,
			//then get stored inside the array
			while(third.hasNext())
			{
				//will read each line of text individually and store the entire line's data
				String dummy = third.next(); 
				
				//this array extracts data from the "dummy" String and separate numbers by using "," as delim
				String[] splitting = dummy.split(",");
				
				numArray[i+0] = Integer.parseInt(splitting[0]); //numArray 12,9,3 etc. = length
				numArray[i+1] = Integer.parseInt(splitting[1]); //numArray 4,2,27 etc. = width
				numArray[i+2] = Integer.parseInt(splitting[2]); //numArray 3,27,8 etc. = height
				i=i+3;
			}
			third.close();
	
			//start filling in our Box array
			for(int a=0;a<lines;a++)
			{
				boxArray[a]=new Box(numArray[(a*3)+0], numArray[(a*3)+1], numArray[(a*3)+2]);
			}
			
			//compile all the read data into one String; will be the first argument for the GUI
			String firstArg = compileString(boxArray, lines);
			
			//volArray will hold all volume values and get sorted
			int[] volArray = new int[lines];
			volArray = findVolumes(boxArray, lines);
			Arrays.sort(volArray);
			
			//create second argument for GUI and initialize it with for loop
			String secondArg="";
			for(int j=0;j<lines;j++)
			{
				secondArg=secondArg+"<html>"+Integer.toString(volArray[j])+"<br/>";
			}
			
			//call GUI here
			BoxGUI GridLayout = new BoxGUI(firstArg, secondArg);
			GridLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			GridLayout.setVisible(true);
			GridLayout.pack();
			GridLayout.setTitle("Box comparison.");
		}
		catch(Exception e)
		{
			System.out.println("No file found.");
			System.exit(0);
		}
	}
}
