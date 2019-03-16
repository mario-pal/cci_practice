import java.util.*;

/*
 * Author: Mario Palma
 * Date: 3/15/2019
 * References: Cracking the Coding Interview 6th edition
 */
public class ch10_1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random generator = new Random();
		int[] list1, list2, copyList1, copyList2, biggerList, smallerList;
		int size1, size2;
		
		System.out.println("I will generate two lists of random numbers in sorted order.");
		System.out.print("Enter the size of the first list: ");
		size1 = scan.nextInt();
		
		System.out.print("Enter the size of the second list: ");
		size2 = scan.nextInt();
		
		list1 = new int[size1];
		list2 = new int[size2];
		copyList1 = new int[size1];
		copyList2 = new int[size2];
		
		for(int i = 0; i < size1; i++) {
			list1[i] = generator.nextInt(1000);
			copyList1[i] = list1[i];
		}
		
		for(int i = 0; i < size2; i++) {
			list2[i] = generator.nextInt(1000);
			copyList2[i] = list2[i];
		}
		
		Alt.mergesort(list1);
		Alt.mergesort(list2);
		Alt.mergesort(copyList1);
		Alt.mergesort(copyList2);
		
		System.out.println("Here are the two lists: ");
		System.out.println("List 1: ");
		for(int i = 0; i < size1 ; i++) {
			System.out.println(list1[i]);
		}
		System.out.println("List 2: ");
		for(int i = 0; i < size2 ; i++) {
			System.out.println(list2[i]);
		}
		
		biggerList = new int[size1+size2];
		
		if(size1 > size2) {
			for(int i = 0; i < size1 ; i++) {
				biggerList[i] = list1[i];
			}
			smallerList = list2;
		}
		else {
			for(int i = 0; i < size2 ; i++) {
				biggerList[i] = list2[i];
			}
			smallerList = list1;
		}
		
		System.out.println("Now I will merge them in sorted order...");
		
		merge(biggerList, smallerList);
		
		System.out.println("Here's my solution: ");
		for(int i = 0; i < biggerList.length ; i++) {
			System.out.println(biggerList[i]);
		}
		
		System.out.println("Here's Laakman's solution: ");
		biggerList = new int[size1+size2];
		
		if(size1 > size2) {
			for(int i = 0; i < size1 ; i++) {
				biggerList[i] = copyList1[i];
			}
			smallerList = copyList2;
		}
		else {
			for(int i = 0; i < size2 ; i++) {
				biggerList[i] = copyList2[i];
			}
			smallerList = copyList1;
		}
		
		Alt.sortedMerge(biggerList, smallerList);
		for(int i = 0; i < biggerList.length ; i++) {
			System.out.println(biggerList[i]);
		}
		
		System.out.println("BYE!!");
		
		
		scan.close();
	}
	
	public static void merge(int[] A, int[] B) {
		int Aendindex = A.length - B.length -1;
		for (int i = 0; i < B.length; i++) 
			A[Aendindex + 1 + i] = B[i];
		Alt.merge(A, new int[A.length], 0, Aendindex ,A.length -1);//mergesort's merge algorithm
	}
	
	

}
