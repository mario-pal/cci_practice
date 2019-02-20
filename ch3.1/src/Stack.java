import java.util.EmptyStackException;

public class Stack<T> {
	private StackNode top;
	
	public Stack() {
		top = null;
	}
	
	public T pop() {
		T retData;
		
		if(top == null)
			throw new EmptyStackException();
		
		retData = top.data;
		top = top.next;
		
		return retData;
	}
	
	public void push(T userInput) {
		StackNode newStackNode = new StackNode(userInput);
		
		newStackNode.next = top;
		top = newStackNode;
	}
	
	public T peek() {
		if(top == null)
			throw new EmptyStackException();
		
		return top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
/*
 **********************************************	
 */
	private class StackNode{
		private T data;
		private StackNode next;
		
		public StackNode(T inputData) {
			data = inputData;
			next = null;
		}
	}
}
