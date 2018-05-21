package com.liuxuan;

import java.util.Arrays;

public class MaoPao {
	public static void bubble_sort(int[] arrays){
		for(int i = 0 ; i < arrays.length ; i++){
			for(int j = i ; j < arrays.length ; j++){
				if(arrays[i] > arrays[j]){
					int temp = arrays[i];
					arrays[i] = arrays[j];
					arrays[j] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arrays = {5, 12, 6, 213, 7, 1, 4, 8, 25, 91};
		Arrays.sort(arrays);
		//bubble_sort(arrays);
		for(int k = 0 ; k < arrays.length ; k++){
			System.out.print(arrays[k] + ", ");
			
		}
	}
}
