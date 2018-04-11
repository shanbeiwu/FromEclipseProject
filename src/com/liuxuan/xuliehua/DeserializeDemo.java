package com.liuxuan.xuliehua;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 
 * @author ɽ����
 *	�ڱ�����ʵ���˷����л�����D��/employee.ser�ļ��ж�ȡEmployee����
 * @date 2-24_M
 */
public class DeserializeDemo {
	public static void main(String[] args) {
		Employee e = null;
		try{
			FileInputStream filein = new FileInputStream("D:/employee.ser");
			ObjectInputStream in = new ObjectInputStream(filein);
			e = (Employee)in.readObject();
			in.close();
			filein.close();
		}catch( FileNotFoundException f){
			f.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			System.out.println("Employee is not be found");
			e1.printStackTrace();
		}
		System.out.println("Deserialized Employee...");
		System.out.println("name: " + e.name);
		System.out.println("address: " + e.address);
		System.out.println("SSN: " + e.SSN);
		System.out.println("number: " + e.number);
	}
}
