package myLibrary.Sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class App {
	
	public static int getRandomValue(int Min, int Max)
    {
          return ThreadLocalRandom
            .current()
            .nextInt(Min, Max + 1);
    }
	
	public static int[] generateRandomArray(int length)
	{
        int leftLimit = 1; 
        int rightLimit = 100; 
        
        int[] arr = new int[length];
        
        for (int i = 0; i < length; i++)
        {
            arr[i] = getRandomValue(leftLimit, rightLimit);
        }
        
        return arr;
    }

	public static void main(String[] args) 
	{
		Interpolation I = new Interpolation();
		//BubbleSort S = new BubbleSort();
		//InsertionSort S = new InsertionSort();
		SelectionSort S = new SelectionSort();
		int min = 10;
		int max = 100;
		
		int arr_size = getRandomValue(min, max); // Generating a random array size for input array
		int key = getRandomValue(min, max); //Generating a random integer search key
		
		int[] arr_interpolation = generateRandomArray(arr_size); //Generating a random array
		int[] arr_sort = generateRandomArray(arr_size); //Generating a random array
		
		// Interpolation Search Output
		
		System.out.println("\nINTERPOLATION SEARCH------------------------------------------------------------------------------");
		
		System.out.println("Array Size: "+arr_size);
		System.out.println("Search key: "+key);
		System.out.println("Input Array: "+Arrays.toString(arr_interpolation));
		
		// Apply interpolation search to find the key
		int out = I.interpolationSearchIterative(arr_interpolation, key);
		
		// Show search output
		if (out != -1)
			System.out.println("FOUND at index "+out);
		else System.out.println("NOT FOUND");
		
		// Sort Output
		
		System.out.println("\nSORTING------------------------------------------------------------------------------");
		
		System.out.println("Array Size: "+arr_size);
		System.out.println("Input Array: "+Arrays.toString(arr_sort));
		
		// Apply a sorting algorithm
		S.X_Sort(arr_sort);
		
		// Show sorted array
		System.out.println("Sorted Array: "+Arrays.toString(arr_sort));
	}

}
