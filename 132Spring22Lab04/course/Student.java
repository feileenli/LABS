package course;

public class Student implements Comparable<Student> {
	private String name;
	private int id;
	private double gpa;
	
	public Student(String name, int id, double gpa) {
		this.name = name;
		this.id = id;
		this.gpa = gpa;
	}
	
	public String toString() {
		return "Name: " + name + ", Id: " + id + ", Gpa: " + gpa;
	}
	
	public int compareTo(Student other) {
		if (other == null) {
			throw new NullPointerException();
		}
		return id - other.id;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ( !(obj instanceof Student) ) {
			return false;
		}
		return compareTo((Student)obj)== 0;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

