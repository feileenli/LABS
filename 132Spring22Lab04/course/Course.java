package course;
import java.util.ArrayList;

public class Course {
	private static final double MINIMUM_GPA = 2.0;
	protected String name; // protected so we see difference in debugger
	private int maxCapacity;
	public int enrolled;  // public so we see the difference in debugger
	private ArrayList<Student> list = null;
	
	public Course(String name, int maxCapacity) {
		this.name = name;
		this.maxCapacity = maxCapacity;
		list = new ArrayList<Student>();
	}
	
	public boolean canEnroll(Student s) {
		boolean answer = false;
		if (s.getGpa() > MINIMUM_GPA && enrolled < maxCapacity) {
			answer = true;
		}
		return answer;
	}
	
	public void enroll(Student s) {
		list.add(s);
		enrolled++;
	}
	
	public String[] justNames() {
		String[] result = new String[list.size()];
		int i=0;
		for (Student student : list) {
			result[i++] = student.getName();
		}
		return result;
	}
	
	public String toString() {
		String result = "Name: " + name;
		result += " Capacity: " + maxCapacity + "\n";
		for (int i=0; i<list.size(); i++) {
			result += list.get(i) + "\n";
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println("Starting Program");
		Course course = new Course("cmsc999", 35);
		
		Student s1 = new Student("Mary", 1, 3.5);
		boolean canEnroll = course.canEnroll(s1);
		System.out.println("Enrollment possible? " + (canEnroll ? "Yes" : "No"));
		
		course.enroll(s1);
		System.out.println(course);
		
		course.enroll(new Student("Peter", 2, 3.7));
		course.enroll(new Student("George", 3, 3.0));
		course.enroll(new Student("Rose", 4, 3.0));
		course.enroll(new Student("Bill", 5, 3.0));
		course.enroll(new Student("Tom", 6, 3.0));
		System.out.println(course);
		
		System.out.println("Names");
		String[] allNames = course.justNames();
		for (String name : allNames) {
			System.out.println(name);
		}
	}
}