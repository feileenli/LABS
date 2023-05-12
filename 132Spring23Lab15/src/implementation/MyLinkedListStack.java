package implementation;

import java.util.NoSuchElementException;

public class MyLinkedListStack<T> implements MyStack<T> {

	/* Leave this public */
	public class Node {

		/* Leave these public */
		public T data;
		public Node next;

		public Node(T d) {
			data = d;
			next = null;
		}
	}

	/* Leave this public */
	public Node head = null;

	@Override
	public void push(T element) {
		Node n = new Node(element);
		n.next = head;
		head = n;
	}

	@Override
	public T pop() {
		if (head == null) {
			throw new NoSuchElementException();
		}
		Node headToReturn = head;
		head = head.next;
		headToReturn.next = null;
		return headToReturn.data;
	}
	

}
