package cracking.the.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorting {
	
	static Integer[] unsorted = {4, 7, 9, 2, 3, 6, 1, 8, 0, 5};

	public static void main(String[] args) {
//		int [] sorted = bubbleSort(unsorted);
		List<Integer> sorted = quickSort(Arrays.asList(unsorted));

		for (int n : sorted)
			System.out.print(n);
	}
	
	public static int[] bubbleSort(int[] data) {
		
		for (int i = 0; i < data.length; i++) {
			boolean sorted = true;
			
			for (int j = i + 1; j < data.length; j++) {
				if (data[i] > data[j]) {
//					int temp = data[i]; // temp variable, below no temp using xor
//					data[i] = data[j];
//					data[j] = temp;
					data[i] = data[i] ^ data[j];
					data[j] = data[i] ^ data[j];
					data[i] = data[i] ^ data[j];
					sorted = false;
				}
			}
			if (sorted) break;
		}
		
		return data;
	}
	
	public static List<Integer> quickSort(List<Integer> data) {
		if (data.size() <= 1) return data;
		else {
			List<Integer> less = new ArrayList<Integer> ();
			List<Integer> greater = new ArrayList<Integer> ();
			
			int pivot = data.get(data.size() / 2);
			for (int n : data) {
				if (n < pivot) less.add(n);
				else if (n > pivot) greater.add(n);
			}
			
			List<Integer> results = new ArrayList<Integer> ();
			results.addAll(quickSort(less));
			results.add(pivot);
			results.addAll(quickSort(greater));
			
			return results;
		}
	}

}
