package com.liuxuan.xuliehua;

/**
 * 
 * @author ɽ����
 * ���л�ģ������
 * @Date 2-24_M
 */

public class Employee implements java.io.Serializable {
	public String name;
	public String address;
	public transient int SSN;
	public int number;
	public void mailCheck(){
		System.out.println("Mailing a check to" + name + " " + address);
	}
}
