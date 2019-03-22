/*
 * Author: Mario Palma
 * Date: 3/21/2019
 * Description: Program that implements the game FizzBuzz
 * Source: Tom Scott https://www.youtube.com/watch?v=QPZ0pIK_wsc
 */
public class FizzBuzz {
	final static private int MAX = 30;
	
	public static void main(String[] args) {
		fizzBuzzOpt();
	}
	
	public static void fizzBuzzNaive() {
		for(int i = 1; i <= MAX; i++) {
			if(i%15 == 0) {
				System.out.println("FizzBuzz!");
			}
			else {
				if(i%3 == 0) {
					System.out.println("Fizz");
				}
				else if(i%5 == 0) {
					System.out.println("Buzz");
				}
				else {
					System.out.println(i);
				}
			}
		}
	}
	
	public static void fizzBuzzOpt() {
		String val;
		for(int i=1; i <= MAX; ++i) {
			val = "";
			if(i%3 == 0) val += "Fizz";
			if(i%5 == 0) val += "Buzz";
			if(val == "") val += i;
			
			System.out.println(val);
			
		}
	}

}
