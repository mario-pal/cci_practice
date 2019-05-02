import java.util.*;

public class ch4_2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arraySize;
		
		System.out.println("I will turn an array to a balanced Binary Search Tree of mininal height");
		System.out.print("How large is your array?");
		arraySize = scan.nextInt();
		
		int[] userArray = new int[arraySize];
		
		for(int i = 0; i < arraySize; i++) {
			System.out.print("Enter element " + (i+1) + ": ");
			userArray[i] = scan.nextInt();
		}
		
		//Sort the array
		Arrays.sort(userArray);
		
		TreeNode bstRoot = arrayToBST(userArray);
		
		//printTheBST
		int height = Math.round((float)Math.floor(Math.log(arraySize)/Math.log(2)));
		
		printTree(bstRoot, height);
		
		System.out.print("BYE!!");
		
	}
	 
	public static TreeNode arrayToBST(int[] inArray) {
		return arrayToBST(inArray, 0, inArray.length - 1);
	}
	
	public static TreeNode arrayToBST(int[] inArray, int start, int end) {
		//base case
		if(end < start) {
			return null;
		}
		
		int middle = (start + end)/2;
		TreeNode root = new TreeNode(inArray[middle]);
		
		root.children[0] = arrayToBST(inArray, start, middle - 1);
		root.children[1] = arrayToBST(inArray, middle + 1, end);
		
		return root;
	}
	
	public static void printTree(TreeNode root, int maxLevel) {
		ArrayDeque<TreeNode> q = new ArrayDeque<TreeNode>();
		int currLevel = 0;
		
		TreeNode currNode = root;
		q.addLast(currNode);
		
		while(!q.isEmpty()) {
			int index = 1;
			//for(int i = 0; i < Math.pow(2.00, maxLevel)/2 - currLevel; i++)
				//System.out.print("\t");
			//currNode = q.removeFirst();
			while(index <= Math.pow(2.00, currLevel) && !q.isEmpty() ) {
				//System.out.print(currNode.toSring() + " ");
				if(!q.isEmpty()) {
					currNode = q.removeFirst();
				}
				System.out.print(currNode.toSring() + " ");
				if(currNode.children[0] != null) {
					q.addLast(currNode.children[0]);
				}
				if(currNode.children[1] != null) {
					q.addLast(currNode.children[1]);
				}

				index++;
			}
			System.out.print("\n");
			currLevel++;
		}
	}

}
