package cloneExercise;

public class Triangle implements Cloneable {

	private int length1, length2, length3;
	
	public Triangle(int a, int b, int c) {
		length1 = a;
		length2 = b;
		length3 = c;
	}
	
	public void setLengths(int a, int b, int c) {
		length1 = a;
		length2 = b;
		length3 = c;
	}
	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (! (other instanceof Triangle)) {
			return false;
		}
		Triangle t = (Triangle)other;
		return t.length1 == length1 && t.length2 == length2 && t.length3 == length3;
	}
	
	public Triangle clone() { 
		try { 
			Triangle theCopy = (Triangle)super.clone(); 	
			return theCopy;	
		} catch (CloneNotSupportedException e) {
			return null;
		}
		
	}
	
}
