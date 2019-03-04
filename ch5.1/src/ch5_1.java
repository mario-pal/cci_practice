import java.util.Scanner;

public class ch5_1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String inputStringN, inputStringM, MintoN = "";
		int M = 0, N = 0, MSBindex, LSBindex;
		
		System.out.print("Enter a string of 1's and 0's: ");
		inputStringN = scan.next();
		
		if(inputStringN.length() < 1 || inputStringN.length() > 32) {
			System.out.println("You must enter a string shorter than 32 characters!");
			System.out.println("Program terminated!");
			return;
		}
		
		System.out.print("Enter ANOTHER SHORTER string of 1's and 0's: ");
		inputStringM = scan.next();
		
		while(inputStringM.length() >= inputStringN.length()) {
			System.out.println("You must enter a SHORTER string!");
			System.out.print("Enter a SHORTER string of 1's and 0's: ");
			inputStringM = scan.next();
		}
		
		System.out.println("Your first string is of size " + inputStringN.length());
		System.out.println("Your second string is of size " + inputStringM.length());
		System.out.println("Now enter the position in string N you would like to insert M: ");
		MSBindex = scan.nextInt();
		LSBindex = MSBindex - (inputStringM.length() - 1);
		
		for(int i = 0; i < inputStringN.length(); i++) {
			if(inputStringN.charAt((inputStringN.length()-1)-i) != '0')
				N = N | (1 << i);
		}
		
		for(int i = 0; i < inputStringM.length(); i++) {
			if(inputStringM.charAt((inputStringM.length()-1) - i) != '0')
				M = M | (1 << i);
		}
		
		System.out.println("This is your first and second string represented as a number: " + N + " " + M);
		System.out.println("Now the insertion begins...");
		
		int MN = insertBits(M, N, MSBindex, LSBindex);
		int check;
		
		for(int i = 0; i < inputStringN.length(); i++) {
				check = MN & (1 << (inputStringN.length()-1)-i);
				if(check != 0)
					MintoN = MintoN + "1";
				else
					MintoN = MintoN + "0";
		}
		
		System.out.println("This is your new string: " + MintoN);
		System.out.print("Bye");
		
		scan.close();
	}
	
	public static int insertBits(int M, int N, int MSBindex, int LSBindex) {
		int mask = clearBitsMSBthroughI(N, LSBindex) | clearBitsIthroughZero(N, MSBindex);
		int updatedN = N & mask;
		int updatedM = M << LSBindex;
		
		return updatedN | updatedM;
	}
	
	public static int clearBitsMSBthroughI(int inputBits, int i) {
		int mask = (1 << i) - 1;
		return inputBits & mask;
	}
	
	public static int clearBitsIthroughZero(int inputBits, int i) {
		int mask = -1 << (i + 1);
		return inputBits & mask;	
	}

}
