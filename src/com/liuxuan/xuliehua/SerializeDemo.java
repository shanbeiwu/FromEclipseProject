package com.liuxuan.xuliehua;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 
 * @author 山贝戊
 * 在本类中实例化Employee对象，并将该对象序列化到一个文件中
 * @date 2-24_M
 */

public class SerializeDemo {
	public static void main(String[] args){
		Employee e = new Employee();
		e.name = "yuxuan liu";
		e.address = "Shanxi, Hanzhong";
		e.SSN = 112233;
		e.number = 151;
		try {
			FileOutputStream fileout = new FileOutputStream("D:/employee.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileout);
			out.writeObject(e);
			out.close();
			fileout.close();
			System.out.println("Serialized data is saved in D:/employee.ser");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
