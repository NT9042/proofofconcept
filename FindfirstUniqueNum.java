package drivers;

import java.util.HashSet;
import java.util.Set;

public class FindfirstUniqueNum {

	public static void main(String[] args) {
		System.out.println(givFirstUniqueNum());
	}
	
	public static int giveFirstUniqueNum() {
		int[] arr = {1, 2, 3, 1, 2, 5, 3, 2 , 5 , 6};
		Set<Integer> duplicates = new HashSet<Integer>();
		
		int i = 0;
		while(i < arr.length) {
			System.out.print(arr[i] + " : ");
			boolean isDuplicateFound = false;
			for (int j = i+1; j < arr.length; j++) {
				System.out.print(arr[j] + "  ");
				if(arr[j] == arr[i] && duplicates.contains(arr[j])) {
					System.out.print("equal");
					duplicates.add(arr[j]);
					isDuplicateFound = true;
					break;
				}
			}
			if(!isDuplicateFound) {
				return arr[i];
			}
			i++;
		}
		return -1;
	}

	public static int givFirstUniqueNum() {
		int[] arr = {1, 2, 3, 1, 2, 5, 3, 2 , 5 , 6};
		Set<Integer> duplicates = new HashSet<Integer>();
		int i = 0;
		while(i < arr.length) {
			System.out.print(arr[i] + " : ");
			boolean isDuplicateFound = false;
			for (int j = i+1; j < arr.length; j++) {
				System.out.print(arr[j] + "  ");
				if(arr[j] == arr[i] || duplicates.contains(arr[j]) ) {
					System.out.print("equal");
					isDuplicateFound = true;
					duplicates.add(arr[j]);
					break;
				}
			}
			if(!isDuplicateFound) {
				return arr[i];
			}
			i++;
		}
		return -1;
	}
	
}
