package edu.happylearn.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * QuickSort algorithm
 * ver1: Take the first element of the array as the pivot
 * @author hu.xu
 *
 */
public class QuickSort {
	int arr[];
	
	public static void main(String[] args) {
		QuickSort m = new QuickSort();
		m.solve();
	}

	private void solve() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++){
			arr[i] = scan.nextInt();
		}
		scan.close();
		
		quickSort(arr, 0, N);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * Quick sort algorithm
	 * @param arr	the array to sort
	 * @param start	the begin index
	 * @param end	the end index
	 */
	private void quickSort(int[] arr, int start, int end) {
		if(start > end){
			return;
		}
		
		int p = partition(arr, start, end);
		quickSort(arr, start, p-1);
		quickSort(arr, p+1, end);
	}

	/**
	 * Take the first element of the array as the pivot 
	 * @param arr	the array to sort
	 * @param start	begin index
	 * @param end	end index	
	 * @return the index to partition
	 */
	private int partition(int[] arr, int start, int end) {
		
		if(start == end){
			return start;
		}
		
		int base = arr[start];
		int p = start;
		for(int i=start+1; i<end; i++){
			if(arr[i] < base){
				p++;
				int temp = arr[p];
				arr[p] = arr[i];
				arr[i] = temp;
			}
		}
		
		arr[start] = arr[p];
		arr[p] = base;
		return p;
	}

}
