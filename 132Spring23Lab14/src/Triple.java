import java.util.Iterator;

public class Triple<T extends Comparable<T>> implements Iterable {
	
	private T smallest, mid, largest;
	
	public Triple(T one, T two, T three) {
		if (one.compareTo(two) != -1) {
			if (three.compareTo(one) != -1) {
				mid = one;
				largest = three;
				smallest = two; 
			} else if(one.compareTo(three) != -1) {
				largest = one; 
				if(three.compareTo(two) != -1) {
					mid = three; 
					smallest = two;
				}
				else if(three.compareTo(two) != 1) {
					mid = two; 
					smallest = three; 
				}
			}
		}

	}
	
	@Override
	public int compareTo(T other) {
		int max = 0; 
		if(other.
		
			
		
		return 0;
	}

	@Override
	public Iterator<T> iterator() {
		Iterator<T> it = new Iterator<T>() {

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public T next() {
				int count = 0; 
				int max = 0;
				if(two < one)
				return null;
			} 
			
		};
	
	} 


}
