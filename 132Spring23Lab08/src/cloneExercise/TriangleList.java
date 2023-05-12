package cloneExercise;

public class TriangleList implements Cloneable {

	Triangle[] list;   // do not make this private
	
	public TriangleList(Triangle[] list) {
		this.list = new Triangle[list.length];
		for (int i = 0; i < list.length; i++) {
			this.list[i] = list[i].clone();     // copy the triangles!
		}
	}
	
	public TriangleList clone() { 
		Triangle[] copy = list.clone(); 
		TriangleList theCopy = new TriangleList(copy); 
		return theCopy 
		;
		
	}
	/* PUT YOUR CLONE METHOD HERE */
}
