import java.awt.*;
import javax.swing.*;

public class BoxGUI extends JFrame 
{
	
	JButton label1, label2;
	
	public BoxGUI(String String1, String String2)
	{
		setLayout(new GridLayout(1,2));
		
		label1 = new JButton(String1);
		add(label1);
		
		label2 = new JButton(String2);
		add(label2);
	}	
	
	public BoxGUI()
	{
		System.out.println("No box to be made...");
	}
	
}
