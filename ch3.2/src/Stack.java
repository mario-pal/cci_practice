import java.util.*;
public class Stack<T extends Comparable<T>> {
	public class StackNode{
		private StackNode next;
		private StackNode prevMin;
		private T element;
		
		public StackNode(T element) {
			this.element = element;
		}
	}
	
	private StackNode top;
	private StackNode minNode;
	
	public boolean isEmpty() {
	  return top == null;	
	}
	
	public T peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		return top.element;
	}
	
	public T min() {
		if(minNode == null) {
			throw new NullPointerException();
		}
		return minNode.element;
	}
	
	public void push(T element) {
		StackNode neoNode = new StackNode(element);
		neoNode.next = top;
		
		if(top == null) {
			minNode = neoNode;
		}
		else if(element.compareTo(minNode.element) < 0) {
			neoNode.prevMin = minNode;
			minNode = neoNode;
		}
		
		top = neoNode;
	}
	
	public T pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		T poppedElement = top.element;
		
		/*if(top.next != null && top.prevMin != null) {
			minNode = top.prevMin;
		}
		else {
			minNode = null;
		}*/
		if(top == minNode) {
			minNode = top.prevMin;
		}
		
		top = top.next;
		
		return poppedElement;
	}
	
	public String toString() {
		StackNode currNode;
		String StackString = "";
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		currNode = top;
		while(currNode != null) {
			StackString += currNode.element + "\n";
			currNode = currNode.next;
		}
		return StackString;
	}
	
}
