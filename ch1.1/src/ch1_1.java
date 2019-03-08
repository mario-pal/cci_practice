import java.util.Scanner;

/*
 * Author: Mario Palma
 * Date: 3/7/2019
 * Purpose: This java class contains my solution to problem 1.1 from McDowell's
 *          Cracking the Coding Interview.
 * References: Cracking the coding interview 6th edition.
 */
public class ch1_1 {
	public static final int MAX_ALPHABET_SIZE = 256; //Assuming extended ASCII text encoding

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String inputString;
		
		System.out.print("Enter a word or sentence: ");
		
		inputString = scan.next();
		
		if(isUnique(inputString))
			System.out.println("Your string is unique!");
		else
			System.out.println("Your string is NOT unique");
		
		System.out.println("BYE!");
		
		scan.close();
	}
	
	public static boolean isUnique(String givenString) {
		if(givenString.length()>MAX_ALPHABET_SIZE)
			return false;
		int[] charFreq = new int[MAX_ALPHABET_SIZE];
		
		for(int i = 0; i < givenString.length(); ++i) {
			if(charFreq[givenString.charAt(i)]> 0)
				return false;
			charFreq[givenString.charAt(i)]++;
		}
		
		return true;
		
	}

}
