
public class Main {

	public static void main(String[] args) {
		char[] numbers = {1, 2, 3};
		int total = 0;
		
		for(int i = 0; i < numbers.length; i++) {
		  total  += numbers[i] + Math.pow(10, numbers.length - 1 - i);		
		}
		
		System.out.println(total);
	}

}
