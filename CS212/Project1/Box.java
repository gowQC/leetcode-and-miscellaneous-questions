public class Box 
{
	//set up instance variables
	int length;
	int width;
	int height;
	
	//getters and setters of length, width, and height
	//setters will check to see if values are greater than one
	public int getLength() 
	{
		return length;
	}

	public void setLength(int length) 
	{
		if(length < 1 )
		{
			System.out.println("All dimensions must be greater than or equal to one.");
			System.exit(0);
		}
		this.length = length;
	}

	public int getWidth() 
	{
		return width;
	}

	public void setWidth(int width) 
	{
		if(width < 1 )
		{
			System.out.println("All dimensions must be greater than or equal to one.");
			System.exit(0);
		}
		this.width = width;
	}

	public int getHeight() 
	{
		return height;
	}

	public void setHeight(int height) 
	{
		if(length < 1 )
		{
			System.out.println("All dimensions must be greater than or equal to one.");
			System.exit(0);
		}
		this.height = height;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		
		if (obj == null) return false;
		
		if (this.getClass() != obj.getClass()) return false;
		
		//make the new object a Box object so we can compare the instance variables with it
		Box other = (Box) obj;
		
		if(this.length != other.length)
		{
			return false;
		}
		
		if(this.width != other.width)
		{
			return false;
		}
		
		if(this.height != other.height)
		{
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString()
	{
		return "L: " + length + " W: " + width + " H: " + height + " V: " + volume();
	}
	
	//no argument constructor for box length, width, height = 1
	public Box()
	{
		length = 1;
		width = 1;
		height = 1;
	}
	
	//constructor with parameters for length, width, and height for box
	public Box(int l, int w, int h)
	{
		
		length = l;
		width = w;
		height = h;
		if(length < 1 || height < 1 || width < 1)
		{	
			System.out.println("All dimensions must be greater than or equal to one.");
			System.exit(0);
		}
	}
	
	//constructor for determining volume
	public int volume()
	{
		return getLength() * getWidth() * getHeight();
	}
	
}
