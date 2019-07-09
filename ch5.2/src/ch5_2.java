import java.util.*;

public class ch5_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String userInput;
		double userNum;
		
		System.out.println("Enter a real number between 0 and 1 and I will print its binary representation (enter q to quit)");
		userInput = scan.next();
		
		while(!userInput.equals("q")) {
			//System.out.print("Enter your number: ");
			//userInput = scan.next();
			userNum = Double.parseDouble(userInput);
		
			System.out.println(doubleToBinary(userNum));
			System.out.print("Enter your number: ");
			userInput = scan.next();
		}
		
		System.out.println("bye!");
	}
	
	public static String doubleToBinary(double num) {
		if(num >= 1 || num <= 0) {
			return "Error";
		}
		
		StringBuilder binarysb = new StringBuilder();
		
		binarysb.append(".");
		
		while(num > 0) {
			if(binarysb.length() >= 32) {//at MOST 32 characters including the "."
				return "ERROR";//break; Since otherwise the user thinks that is the correct double to binary conversion
			}
			num *= 2;
			if(num >= 1) {
				binarysb.append("1");
				num -= 1;
			}
			else {
				binarysb.append("0");
			}
		}
		
		return binarysb.toString();
	}

}
