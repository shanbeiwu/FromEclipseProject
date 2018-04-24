package com.liuxuan.binarysearch;

import java.util.Arrays;

import com.sun.org.apache.regexp.internal.recompile;

/**
 * 二分法查询：要求查询数据必须采用顺序存储结构/必须按照关键字大小有序排列
 * @author 山贝戊
 *
 */
public class BinarySearch {
	/**
	 * 冒泡排序
	 * 
	 * @param arrays
	 */
	public static void maoPao(int[] array){
		for(int i = 0; i < array.length; i++){
			for(int j = i; j < array.length; j++){
				if(array[i] > array[j]){
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					
				}
			}
		}
	}
	
	/**
	 * 二分法算法：
	 * 
	 * @param srcArray  有序数组
	 * 
	 * @param des  查找元素
	 * 
	 * @return des的数组下标，没找到返回-1 
	 */
	public static int binarySearch(int[] srcArray, int des){
		int low = 0;
		int heigh = srcArray.length-1;
		while (low <= heigh) {
			int middle = (low + heigh) / 2;
			if(des == srcArray[middle]){
				return middle;
			}else if(des < srcArray[middle]){
				heigh = middle - 1;
			}else {
				low = middle + 1;
			}
			
		}
		return -1;
	}
	
	public static int bs(int[] array, int des) {
		int low = 0;
		int heigh = array.length-1;
		while (low <= heigh) {
			int middle = (low + heigh) / 2;
			if (des == array[middle]) {
				return middle;
			} else if (des < array[middle]) {
				heigh = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return -1;
	}
	
	 /**   
	  *二分查找特定整数在整型数组中的位置(递归)   
	  *@param dataset   
	  *@param data   
	  *@param beginIndex   
	  *@param endIndex   
	  *@return index   
     */  
	public static int binarySearch(int[] dataset, int data, int beginIndex, int endIndex){
		int midIndex = (beginIndex + endIndex) / 2;
		System.out.println("--"+midIndex);
		if(data < dataset[beginIndex] || data > dataset[endIndex] || beginIndex > endIndex){
			return -1;
		}
		if(data < dataset[midIndex]){
			return binarySearch(dataset, data, beginIndex, midIndex - 1);
		}else if (data > dataset[midIndex]){
			return binarySearch(dataset, data, midIndex + 1, endIndex);
		}else {
			return midIndex;
		}
		
	}
	
	public static void main(String[] args) {
		int[] arrays = {5, 12, 6, 213, 7, 1, 4, 8, 25, 91};
		maoPao(arrays);
		for(int k = 0; k < arrays.length; k++){
			System.out.print(arrays[k] + ", ");
		}
		System.out.println("\n"+arrays.length);
		System.out.println(binarySearch(arrays, 12));
		System.out.println("*" + binarySearch(arrays, 12, 0, arrays.length-1));
	}
}
