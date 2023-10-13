package myLibrary.Sort;

public class SelectionSort {

	public void X_Sort(int[] array) {
		
		int min, temp;
		for (int i = 0; i< array.length; i++) {
			min = i;
			
			for(int j = i +1; j < array.length; j++) {
				if(array[j] < array[min]) {
					min = j;
				}
			}
			
			temp = array[i];
			array[i] = array[min];
			array[min] = temp;
			
		}
	}
}
