package com.liuxuan;

/**
 * 一列数的规则如下: 1、1、2、3、5、8、13、21、34 ，求第30位数是多少？使用递归实现
 * @author 山贝戊
 *
 */

public class DiGuiDemo {
	
	/**
	 * 
	 * @param index 下标参数
	 * @return 返回1或那满足条件的值
	 *  
	 */
	public static int fab(int index) {
		if (index == 1 || index ==2) {
			return 1;
		} else {
			return fab(index - 1) + fab(index - 2);
		}
	}
	
	public static void aaa() {
		String str = "14楼号";
		String str2 = str.substring((str.length())-2);
		System.out.println(str2);
	}
	
	
	public static void main(String[] args) {
		//System.out.println(fab(8));
		aaa();
	}
}
