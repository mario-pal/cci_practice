import java.util.EmptyStackException;

/*
 * Purpose: This stack is implemented using a single array. Furthermore, this single
 * array can manage and contain THREE stacks.
 * Date: 2/21/2019
 * Note: I could not make the this IntTriStack generic (implemented using an array)
 *       as Java "Cannot create a generic array of T".
 */
public class IntTriStack {
	private int[] arrayOfStacks, sizes;
	private int numberOfStacks = 3, sizeOfEachStack;
	
	//Creates an array that contains three stacks each of the same size
	public IntTriStack(int size) {
		sizeOfEachStack = size;
		arrayOfStacks = new int[numberOfStacks * sizeOfEachStack];
		sizes = new int[numberOfStacks];
	}
	
	public void push(int stackNum, int data) throws FullStackException{
		if (isFull(stackNum))
			throw new FullStackException("Stack " + stackNum + " is Full");
		//arrayOfStacks[sizeOfEachStack*stackNum + size[stackNum]];
		arrayOfStacks[indexTop(stackNum) + 1] = data;
		sizes[stackNum]++;
	}
	
	public int pop(int stackNum) {
		if(isEmpty(stackNum))
			throw new EmptyStackException();
		
		int dataReturn = arrayOfStacks[indexTop(stackNum)];
		sizes[stackNum] = 0; //clear top value from stack
		sizes[stackNum]--;
		return dataReturn;
	}
	
	public int peek(int stackNum) {
		if(isEmpty(stackNum))
			throw new EmptyStackException();
		
		int dataReturn = arrayOfStacks[indexTop(stackNum)];
		return dataReturn;
	}
	
	public int indexTop(int stackNum) {
		int offset = sizeOfEachStack*stackNum;
		int top = offset + sizes[stackNum] - 1;
		return top;
	}
	
	public boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}
	
	public boolean isFull(int stackNum) {
		return sizes[stackNum] == sizeOfEachStack;
	}
	
}
