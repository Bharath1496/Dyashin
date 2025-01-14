package Practice;

import java.util.*;

public class ArrayLogicQuestions {

	
	
	    public static int findMax(int[] arr) {
	        int max = arr[0];
	        for (int num : arr) {
	            if (num > max) {
	                max = num;
	            }
	        }
	        return max;
	    }

	    
	    public static int[] reverseArray(int[] arr) {
	        int[] reversed = new int[arr.length];
	        for (int i = 0; i < arr.length; i++) {
	            reversed[i] = arr[arr.length - 1 - i];
	        }
	        return reversed;
	    }

	    
	    public static boolean isSorted(int[] arr) {
	        for (int i = 1; i < arr.length; i++) {
	            if (arr[i] < arr[i - 1]) {
	                return false;
	            }
	        }
	        return true;
	    }

	   
	    public static int findSecondLargest(int[] arr) {
	        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
	        for (int num : arr) {
	            if (num > largest) {
	                secondLargest = largest;
	                largest = num;
	            } else if (num > secondLargest && num != largest) {
	                secondLargest = num;
	            }
	        }
	        return secondLargest;
	    }

	    
	    public static int[] rotateArray(int[] arr, int k) {
	        int n = arr.length;
	        int[] rotated = new int[n];
	        for (int i = 0; i < n; i++) {
	            rotated[(i + k) % n] = arr[i];
	        }
	        return rotated;
	    }

	    public static void main(String[] args) {
	        int[] arr = {3, 5, 1, 9, 2};
	        System.out.println("Max: " + findMax(arr));
	        System.out.println("Reversed: " + Arrays.toString(reverseArray(arr)));
	        System.out.println("Is Sorted: " + isSorted(arr));
	        System.out.println("Second Largest: " + findSecondLargest(arr));
	        System.out.println("Rotated by 2: " + Arrays.toString(rotateArray(arr, 2)));
	    }
	
}
