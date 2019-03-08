/* Author: Mario Palma
 * Date: 2/9/2019
 * About: The IntList (LinkedList) class wraps the NumNode (node) class. 
 * 		  This is meant as practice for writing a SINGLY linked list in Java
 * References: Java Software Solutions 7th Edition by Lewis & Loftus pages 622-623 
 * 			   and https://codereview.stackexchange.com/questions/141560/an-iterable-implementation-of-linkedlist
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> {
	private Node headNode;//Node<T> headNode;
	private int length;
	//private LinkedListIterator thisItr;
	
	public LinkedList() {
		headNode = null;
		length = 0;
	}
	
	public int getLength() {
		return length;
	}
	
	public String toString() {
		String result = "";
		
		/*Node<T>*/Node currNode = headNode;
		
		while(currNode != null) {
			result += currNode.value + "\n";
			currNode = currNode.next;
		}
		return result;
	}
	
	/*public T getCurrElement() {
		return thisItr.getCurrVal();
	}*/
	
	/*
	 * About append: This function adds a node to the end of the linked list
	 */
	public void append(T givenVar) {
		/*Node<T>*/Node currNode;
		/*Node<T>*/Node newNode = new Node(givenVar);//Node<T>(givenVar);
		
		if(headNode == null) {
			headNode = newNode;
			length++;// 
		}
		else {
			currNode = headNode;
		
			while(currNode.next != null)//assuming the list has at least one node
				currNode = currNode.next;
				
			currNode.next = newNode;
			length++;//
		}
	}
	
	/*
	 *About deleteNode: deletes a node from this single linked list (IntList)
	 */
	public void deleteNode(T givenVar) { //NOT NumNode givenNode
		/*Node<T>*/Node currNode, prevNode = null;
		
		if(headNode == null)
			return;
		
		//if(headNode.value == givenVar){
		if(headNode.value.equals(givenVar)){
		  prevNode = headNode;
		  headNode = headNode.next;
		  prevNode.next = null;//unlink the former head of the linked list(although it may not
		  						//be a necessary thing to do in Java as the garbage collector
		  						//takes care of objects that are not referenced.
		  length--;
		}
		else {
			currNode = headNode;
			
			while(currNode != null && !(currNode.value.equals(givenVar))) {
				prevNode = currNode;
				currNode = currNode.next;
			}
			
			if(currNode != null) {
				prevNode.next = currNode.next;
				currNode.next = null;
				length--;
			}
		}
	}
	
	public Iterator<T> getIterator(){
		/*thisItr =*/return new LinkedListIterator();
		//return thisItr;
	}
	/*
	 * ****************************************
	 * ****************************************
	 */
	private class Node{//class Node<T>{//This gives a warning that the T here masks the outer class T
		public T value;
		public Node next;//Node<T> next;//The inner class has access to the type T
		
		public Node(T input) {
			value = input;
			next = null;
		}
	}
	
	private class LinkedListIterator implements Iterator<T>{
		private Node currNode;//Node<T> currNode;
		
		public LinkedListIterator() {
			currNode = headNode;
		}
		
		public boolean hasNext() {//Note: You have to use the next() method first for this to make sense
			return currNode != null;
		}
		
		public T next() {
			if(hasNext()) {
				T value = currNode.value;
				currNode = currNode.next;
				return value;
			}else
				throw new NoSuchElementException("Iterator Exceeded!");
		}
		
		/*public T getCurrVal() {
			if(hasNext())
				return currNode.value;
			else
				throw new NoSuchElementException("Iterator exceeded when trying to access value in current node!");
		}*/
		
	}
}
