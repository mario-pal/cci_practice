import java.util.*;

public class ch1_2 {

	public static final int EXTENDED_ASCII = 256;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner scan = new Scanner(System.in);
	String str1, str2;
	
	System.out.print("Hello. Please enter a string: ");
	str1 = scan.nextLine();
	System.out.print("Please enter a second string: ");
	str2 = scan.nextLine();
	
	if(isPermutation(str1, str2)) {
		System.out.println("These strings ARE permutations of each other!");
	}else {
		System.out.println("These strings ARE NOT permutations of each other");
	}
	
	System.out.print("Bye!");
	
}

	public static boolean isPermutation(String str1, String str2) {
	    if(str1.length() != str2.length())
	    	return false;
	    
	    int[] freq = new int[EXTENDED_ASCII];
	    
	    for (int i = 0; i < str1.length(); ++i) {
	    	freq[str1.charAt(i)]++;
	    }
		
	    for(int i = 0; i < str2.length(); ++i) {
	    	freq[str2.charAt(i)]--;
	    	if(freq[str2.charAt(i)] < 0) {
	    		return false;
	    	}
	    }
	    
		return true;	
	}
	
}
