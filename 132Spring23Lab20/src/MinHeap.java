import java.util.ArrayList;
import java.util.List;

public class MinHeap<T extends Comparable<T>> {

	public ArrayList<T> data;

	/* We are going to implement a min-heap using an
	 * ArrayList instead of a plain array.
	 * 
	 * We don't need a separate "size" variable.  We just add
	 * or remove things from the end of the ArrayList and then
	 * the size of the ArrayList automatically matches the 
	 * size of the heap.
	 * 
	 * [Internally the ArrayList maintains an array that is 
	 * larger than the portion being used; we are delegating
	 * the job of "re-sizing nicely and keeping track of what
	 * portion of the array is used" to the ArrayList.]
	 * 
	 * There are two methods for you to implement.
	 * 
	 * I have provided some PublicTests so that you can check
	 * your work.
	 */

	
	
	/* Here are the formulas for computing the indices of the 
	 * parent, left child, and right child of the Node at the 
	 * currentIndex.
	 */
	private static int leftChildIndex(int currentIndex) {
		return 2 * currentIndex + 1;
	}

	private static int rightChildIndex(int currentIndex) {
		return 2 * currentIndex + 2;
	}

	private static int parentIndex(int currentIndex) {
		return (currentIndex - 1) / 2;
	}

	
	/* Constructor that creates an empty ArrayList */
	public MinHeap() {
		data = new ArrayList<>();
	}

	/* Add this element to the heap.  Implement this following 
	 * the algorithm presented in class.
	 */
	public void add(T element) {
		data.add(element);
		int myIndex = data.size() - 1;

		while (true) {
			int parentIndex = parentIndex(myIndex);
			if (parentIndex >= 0 && data.get(parentIndex).compareTo(element) > 0) {
				swap(myIndex, parentIndex);
				myIndex = parentIndex;
			} else {
				return;
			}
		}
	}
	private void swap(int a, int b) {
		T temp = data.get(a);
		data.set(a, data.get(b)); 
		data.set(b, temp); 
	}

	/*
	 * Implement this following the algorithm demonstrated in the lecture. THIS
	 * METHOD IS CHALLENGING!
	 * 
	 * First study the ArrayList API a bit:
	 * 
	 * 1. Be sure you know how to remove the element at the end of the ArrayList.
	 * 
	 * 2. Be sure you know how to REPLACE the element at the front of the ArrayList.
	 * (Hint: Don't use "add", use "set"!)
	 */
	public T removeSmallest() {
		T toReturn = data.get(0); 
		T end = data.remove(data.size() - 1); 
		
		if(data.size() == 0) {
			return toReturn;
		}
		data.set(0, end);
		int currentIndex = 0; 
		
		while(true) {
			int left = leftChildIndex(currentIndex); 
			int right = rightChildIndex(currentIndex); 
			boolean needToSwap = false; 
			T leftElement = null, rightElement = null;

			
		}
	}

}
