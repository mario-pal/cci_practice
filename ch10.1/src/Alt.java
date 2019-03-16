
public class Alt {
	public static void mergesort(int[] array) {
		mergesort(array, new int[array.length], 0, array.length-1);
		
	}
	
	public static void sortedMerge(int[] A, int[] B) {
		int AcurrIndex =A.length-B.length-1;;
		int BcurrIndex = B.length-1;
		int currIndex = A.length - 1;
		
		while(BcurrIndex >= 0) {
			if(AcurrIndex >= 0 && A[AcurrIndex] > B[BcurrIndex] ) {
				A[currIndex] = A[AcurrIndex];
				AcurrIndex--;
			}
			else {
				A[currIndex] = B[BcurrIndex];
				BcurrIndex--;
			}
			currIndex--;
		}
	}
	
	public static void mergesort(int[] array, int[] helper, int low, int high) {
		if(low >= high)
			return;
		int mid = (low+high)/2;
		
		mergesort(array, helper, low, mid);
		mergesort(array, helper, mid+1, high);
		merge(array, helper, low, mid, high);
	}
	public static void merge(int[] A, int[] helper, int low, int mid, int high) {
		int curr = low;
		int helperLeft = low;
		int helperRight = mid + 1;
		
		for(int i = 0; i <= high; i++) {
			helper[i] = A[i];
		}
		
		while(helperLeft <= mid && helperRight <= high) {
			if(helper[helperLeft] <= helper[helperRight]) {
				A[curr] = helper[helperLeft];
				helperLeft++;
			}
			else {
				A[curr] = helper[helperRight];
				helperRight++;
			}
			curr++;	
		}
		
		int remainder = mid - helperLeft;
		
		for(int i = 0; i <= remainder; i++) {
			A[curr + i] = helper[helperLeft + i];
		}
	}
}
