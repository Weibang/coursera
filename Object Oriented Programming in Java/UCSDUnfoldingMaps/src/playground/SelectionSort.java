package playground;

public class SelectionSort {
	
	public static int[] sortArray(int[] arr) {
		
		int indexMin = 0;
		
		for (int i=0; i < arr.length-1; i++) {
			indexMin = i;
			for (int j=i+1; j < arr.length; j++) {
				if (arr[j] < arr[indexMin])
					indexMin = j;
			}
			
			// Swap arr[i] <-> arr[indexMin]
			int temp = arr[i];
			arr[i] = arr[indexMin];
			arr[indexMin] = temp;
		}
		
		return arr;
	}

	public static void main(String args[]) {
		int[] arr = {7, 16, 66, 43, 97, 51};
		int[] arr2 = {7, 16, 43, 51, 66, 97};
		
		System.out.println("Original arrays:");
		System.out.println("---------------");
		for (int i=0; i<arr.length; i++)
			System.out.println("Pos #" + i + "\tArray 1: " + arr[i] + "\tArray 2: " + arr2[i]);
		
		arr = sortArray(arr);
		arr2 = sortArray(arr2);
		
		System.out.println("\nSorted arrays:");
		System.out.println("--------------");
		for (int i=0; i<arr.length; i++)
			System.out.println("Pos #" + i + "\tArray 1: " + arr[i] + "\tArray 2: " + arr2[i]);
		
	}
}
