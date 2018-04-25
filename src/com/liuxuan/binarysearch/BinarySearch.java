package com.liuxuan.binarysearch;

import java.util.Arrays;

import com.sun.org.apache.regexp.internal.recompile;

/**
 * ���ַ���ѯ��Ҫ���ѯ���ݱ������˳��洢�ṹ/���밴�չؼ��ִ�С��������
 * @author ɽ����
 *
 */
public class BinarySearch {
	/**
	 * ð������
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
	 * ���ַ��㷨��
	 * 
	 * @param srcArray  ��������
	 * 
	 * @param des  ����Ԫ��
	 * 
	 * @return des�������±꣬û�ҵ�����-1 
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
	  *���ֲ����ض����������������е�λ��(�ݹ�)   
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
