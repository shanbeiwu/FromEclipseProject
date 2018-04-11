package com.liuxuan.xuliehua;

/**
 * 
 * @author 山贝戊
 * 序列化模拟用例
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
