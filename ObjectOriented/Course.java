package ObjectOriented;
//Class for a Course Object
//Kendall McCullom

public class Course 
{
	//static variables
	public static final String SCHOOL = "Boston College";
	private static int numberOfCourses;
	
	//instance variables
	private String nameOfCourse;
	private int enrollment;
	private char semseterOffered;
	
	public Course()
	{
		this("Computer Science II", 40, 'f');
	}

	public Course(String n, int e, char s)
	{
		//setName(n);
		//setEnrollment(e);
		//setSemester(s);
		nameOfCourse = n;
		enrollment = e;
		semseterOffered = s;
		numberOfCourses++;
	}
	
	//static method
	public static int numberOfCourses()
	{
		return numberOfCourses;
	}
	
	//getters
	public String getName()
	{
		return nameOfCourse;
	}
	
	public int getEnrollment()
	{
		return enrollment;
	}
	
	public char getSemester()
	{
		return semseterOffered;
	}
	
	//setters
	public void setName(String c)
	{
		nameOfCourse = c;
	}
	
	public void setEnrollment(int e)
	{
		enrollment = e;
	}
	
	public void setSemester(char s)
	{
		semseterOffered = s;
	}
	
	public void addStudent()
	{
		//setEnrollment(enrollment+1);
		enrollment++;
	}
	
	public void removeStudent()
	{
		//setEnrollment(enrollment-1);
		enrollment--;
	}
	
	public boolean hasSameEnrollment (Course c)
	{
		if (this.enrollment == c.enrollment)
		{
			return true;
		}
		return false;
	}
	
	//overridden method
	public String toString()
	{
		return "Name\t\t" + nameOfCourse + "\nEnrollment\t" + enrollment + "\nFormat\t\t" + semseterOffered;
	}
}	
