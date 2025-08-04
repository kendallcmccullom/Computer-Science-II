package ObjectOriented;
/*
 * driver program for Course class
 */

public class CourseOfferings
{
	public static void main (String [] args)
	{
		// constructors
		Course c1 = new Course("Computer Science I", 46, 'b');
		Course c2 = new Course();
		Course c3 = new Course("Compilers", 12, 'b');
		Course c4 = new Course("Computer Science I", 51, 'b');
		Course c5 = new Course("Computer Organization", 44, 'f');
		Course c6 = new Course("Systems Programming", 3, 'f');
		Course c7 = new Course("Algorithms", 45, 's');

		// static variables and methods
		System.out.println("What is the school name? " + Course.SCHOOL);
		System.out.println("How many computer science course are being "
			+ "offered? " + Course.numberOfCourses());
		System.out.println("Another one has just been added!");
		Course c8 = new Course();
		System.out.println("Here's the updated number: " 
			+ Course.numberOfCourses());
		
		// overridden method (toString())
		Course [] classes = {c1, c2, c3, c4, c5, c6, c7, c8};
		System.out.println("Here are the courses:\n");
		for (int i = 0; i < classes.length; i++)
		{
			System.out.println("c" + (i+1) + "\n" + classes[i].toString()); 
			System.out.println();
		}

		// getters and setters
		System.out.println("What is the name of c6? " + c6.getName());
		System.out.println("At BC it's called Computer Systems, so let's "
			+ "change it:"); 
		c6.setName("Computer Systems");
		System.out.println(c6.getName());
		System.out.println("\nWhat is the enrollment of c6? " 
			+ c6.getEnrollment());
		System.out.println("It looks like the 0 was left off. Let's fix that:");
		c6.setEnrollment(30);
		System.out.println(c6.getEnrollment());
		System.out.println("\nWhat semester is Compilers offered? " +
			c6.getSemester());
		System.out.println("It's actually offered just in the spring, so let's"				+ " change that"); 
		c7.setSemester('s');
		System.out.println(c7.getSemester());

		// instance methods
		System.out.println("\nSomeone just dropped c6");
		c6.removeStudent();
		System.out.println("Here's the updated enrollment: " 
			+ c6.getEnrollment());
		for (int i = 0; i < 3; i++)
		{
			c6.addStudent();
		}
		System.out.println("\nThree students just added the course");
		System.out.println("Here's the updated enrollment: " 
			+ c6.getEnrollment());
		System.out.println("\nDo c2 and c3 have the same enrollment? " +
			(c2.hasSameEnrollment(c3) ? "yes" : "no"));
		System.out.println("Do c2 and c8 have the same enrollment? " +
			(c2.hasSameEnrollment(c8) ? "yes" : "no"));
	}
}
