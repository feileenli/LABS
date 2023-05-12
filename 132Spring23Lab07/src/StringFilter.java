import java.util.ArrayList;
import java.util.Iterator;

public class StringFilter implements Iterable<String>{

	private ArrayList<String> list;
	private int lengthToKeep;
	
	private int i; 
	
	public StringFilter() {
		
	}
	
	public StringFilter(ArrayList<String> list, int length) {
		this.list = list;
		this.lengthToKeep = length;
	}
	
	public void setLengthToKeep(int newLength) {
		lengthToKeep = newLength;
	}
	
	@Override
	public Iterator<String> iterator() {
		return new StringFilterIterator();
	}
	
	/* Fill this in according to the instructions */
	private class StringFilterIterator implements Iterator<String> {
		
		
	}
}
