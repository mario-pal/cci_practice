import java.util.Scanner;
/*
 * Author: Mario Palma
 * Date: 3/13/2019
 */
public class ch8_1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numSteps;
		System.out.println("This program calculates the number of possible paths");
		System.out.println("you can take to reach the last step of stairs if you could");
		System.out.println("take 1,2 or 3 steps at a time.");
		System.out.print("Enter the number of steps: ");
		numSteps = scan.nextInt();
		
		System.out.print(countWays(numSteps));
	}
	
	public static int countWays(int numSteps) {
		if(numSteps < 0) return 0;
		if(numSteps == 1 || numSteps == 0) return 1;
		
		return countWays(numSteps - 1) + countWays(numSteps - 2) + countWays(numSteps - 3);		
	}
	//Note: The int data type used to store the number of ways can overflow
	public static int countWaysMem(int numSteps, int[] cache) {
		if(numSteps<0)return 0;
		else if(numSteps == 0) return 1;
		else if(cache[numSteps] > 0) return cache[numSteps];
		else {
			cache[numSteps] = countWaysMem(numSteps-1, cache) 
					+ countWaysMem(numSteps-2, cache) 
					+ countWaysMem(numSteps-3, cache);
			return cache[numSteps];
		}
	}
	
	public static int countWaysMem(int numSteps) {
		return countWaysMem(numSteps, new int[numSteps+1]);
	}

}
