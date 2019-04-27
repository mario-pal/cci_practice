import java.util.*;

public class ch3_2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice, value;
		System.out.println("Welcome to Stack Manager!");
		System.out.println("In this program you can put and remove integers from the stack.");
		System.out.println("Furthermore, I can keep track fo the minimum value.");
		Stack myStack = new Stack();
		do {
			System.out.println("====================================");
			System.out.println("1: Push");
			System.out.println("2: Pop");
			System.out.println("3: see top");
			System.out.println("4: see minimum");
			System.out.println("5: see entire list");
			System.out.print("Choose an option: ");
			choice = scan.nextInt();
			
			switch(choice) {
			case 1: 
				System.out.println("Enter value to push: ");
				value = scan.nextInt();
				myStack.push(value);
				break;
			case 2:
				try {
					myStack.pop();
					System.out.println("Popped from the stack!");
				}
				catch(EmptyStackException ex){
					System.out.println("THE STACK IS EMPTY!");
				}
				break;
			case 3:
				try {
					System.out.println("The element on top is: " + myStack.peek());
				}
				catch(EmptyStackException ex) {
					System.out.println("THE STACK IS EMPTY!");
				}
				break;
			case 4:
				try {
					System.out.println("The current minimum is: " + myStack.min());
				}
				catch(NullPointerException ex){
					System.out.println("THE STACK IS EMPTY!");
				}
				break;
			case 5:
				try {
					System.out.println(myStack.toString());
				}
				catch(EmptyStackException ex) {
					System.out.println("THE STACK IS EMPTY!");
				}
				break;
			default:
				System.out.println("");
			
			}
		}while(choice != -1);
		System.out.println("BYE!!");

	}

}
