package com.liuxuan.binarysearch;

public class Aaaa {
	
	public static int Tttt1(int[] array, int des){
		int low = 0;
		int heigh = array.length-1;
		while(low <= heigh){
			int min = (low + heigh) / 2;
			if( des == array[min]){
				return min;
			}else if( des < array[min]){
				heigh = min - 1;
			}else{
				low = min + 1;
			}
		}
		return -1;
	}
	
	public static int Tttt2(int[] array, int data, int begin, int end){
		int min = (begin + end) / 2;
		if(data < array[begin] || data > array[end] || begin > end){
			return -1;
		}
		if(data < array[min]){
			return Tttt2(array, data, begin, min - 1);
		}else if( data > array[min]){
			return Tttt2(array, data, min + 1, end);
		}else{
			return min;
		}
	}
	
	public static boolean Tttt3(String str){
		boolean flag = false;
		String[] strarr = str.split(",");
		for(int i = 0; i < strarr.length; i++){
			for(int j = 0; j < strarr.length; j++){
				if(i != j){
					if(strarr[i].equals(strarr[j])){
						flag = true;
						break;
					}
				}
			}
		}
		return flag;
	}
	
	public static void main(String[] args) {
		String str = "1,0,2";
		System.out.println(Tttt3(str));
	}
}
