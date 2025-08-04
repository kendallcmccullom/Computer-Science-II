package ObjectOriented;
public class BCStudent 
{
	public static final String MASCOT = "eagle";
	private static int numberOfStudents; //by default this starts at 0 - this is a global variable
	
	private String major; //default is null
	private int year; //default is 0
	
	public BCStudent()
	{
		major = "computer science";
		numberOfStudents++;
	}
	
	public String getMajor() //getter
	{
		return major;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public void setMajor(String m) //setter or (string major)
	{
		major = m; //this.major = major;
	}
	
	public void setYear(int y)
	{
		year = y;
	}
	
	public static int numberOfStudents()
	{
		return numberOfStudents;
	}

	public static void main (String [] args)
	{
		BCStudent s1 = new BCStudent(); //must create an object
		System.out.println(s1.major);
	}
	
}
