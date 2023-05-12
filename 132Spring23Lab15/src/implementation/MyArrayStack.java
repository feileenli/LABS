package implementation;

import java.util.NoSuchElementException;

/* Leave this here to avoid irritating 
 * warnings from Eclipse. */
@SuppressWarnings("unchecked")

public class MyArrayStack<T> implements MyStack<T> {

	/* Keep these public */
	public T[] array;
	public int size; // Number of elements on the stack,
						// I.e.: How much of the
						// array contains data

	public MyArrayStack() {
		array = (T[]) new Object[10];
		size = 0;
	}

	@Override
	public void push(T element) {
		if (size == array.length) {
			T[] temp = (T[]) new Object[array.length * 2];

			for (int i = 0; i < array.length; i++) {
				temp[i] = array[i];
			}
			array = temp;
		}
		array[size++] = element;

	}

	@Override
	public T pop() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return array[--size];
	}

}
