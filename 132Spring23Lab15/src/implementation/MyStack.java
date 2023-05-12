package implementation;

public interface MyStack<T> {
	
	public void push(T element);
	
	/* Throw a NoSuchElementException if stack is empty */
	public T pop();
}
