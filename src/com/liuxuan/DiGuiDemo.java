package com.liuxuan;

/**
 * һ�����Ĺ�������: 1��1��2��3��5��8��13��21��34 �����30λ���Ƕ��٣�ʹ�õݹ�ʵ��
 * @author ɽ����
 *
 */

public class DiGuiDemo {
	
	/**
	 * 
	 * @param index �±����
	 * @return ����1��������������ֵ
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
		String str = "14¥��";
		String str2 = str.substring((str.length())-2);
		System.out.println(str2);
	}
	
	
	public static void main(String[] args) {
		//System.out.println(fab(8));
		aaa();
	}
}
