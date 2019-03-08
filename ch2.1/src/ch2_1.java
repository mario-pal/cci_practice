/* Author: Mario Palma
 * Date: 2/13/2019
 * About: This is the driver class meant to test the implementation of my answer to question 2_1 from CtCI
 * References: https://stackoverflow.com/questions/34885463/java-insert-dimensions-to-complete-expression-referencetype
 * 			   https://stackoverflow.com/questions/47682179/how-does-next-method-on-iterators-work 
 */
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class ch2_1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		LinkedList<String> intList = new LinkedList<String>();
		int listLength;
		
		System.out.print("Enter size of the list[from 1 to 10]: ");
		listLength = scan.nextInt();
		
		for(int i = 0; i < listLength; i++) {
			System.out.print("Enter the value of element " + (i + 1) + ": ");
			intList.append(scan.next());
		}
		
		System.out.println("You have made the following list: ");
		System.out.println(intList.toString());
		
		System.out.println("Duplicate values in your list will now be removed!\n" + "ENTER any KEY to continue...");
		scan.hasNext();
		
		removeDup(intList);
		
		System.out.println("This is now your list:");
		System.out.println(intList.toString());
		System.out.println("Bye!");
		
		scan.close();
	}
	
	/* Note: We assume that the type of the elements within the linked list passed to
	 * removeDup is known as it will be the type declared in the main function.
	 * Runtime: O(L) where L is the length of the linked list
	 * Space Complexity: O(L) as we use the hash set to help check for duplicates
	 */
	public static void removeDup(LinkedList<String> myList) {
		HashSet<String> hs = new HashSet<String>(); 
		
		Iterator<String> itr = myList.getIterator();
		
		while(itr.hasNext()) {
			String currValue = itr.next();
			if(hs.contains(currValue)) { 
				myList.deleteNode(currValue);
				System.out.println(myList.toString());
			}
			else
				hs.add(currValue);	
		}
	}

}
