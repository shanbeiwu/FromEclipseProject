package com.liuxuan.file_string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class File_StringUtil {
	
	private File_StringUtil(){
		throw new AssertionError();
	}
	
	/**
	 * ͳ�Ƹ����ļ��и����ַ����ĳ��ִ���
	 * @param filename(ͳ���ļ�)
	 * @param word(����Ҫƥ����ֶ�)
	 * @return counter(���ֵĲ����)
	 */
	
	public static int countWordInFile(String filename, String word){
		int counter = 0;
		//���ļ��������ļ�
		try(FileReader fr = new FileReader(filename)){
			//����ʹ��Ĭ�ϴ�С�����뻺�����Ļ����ַ�������
			try(BufferedReader br = new BufferedReader(fr)){
				String line = null;
				//�ж�line���ļ�ÿ�������Ƿ�Ϊnull
				while((line = br.readLine()) != null){
					int index = -1;
					//�ж�ÿһ�еĳ����ǻ����ڻ�������ֵĳ���&&������ÿһ�г��ֵ�����ֵ���ڻ����0
					while((line.length() >= word.length() && (index = line.indexOf(word)) >= 0)){
						counter++;
						//�������ȡline�����ֵ�����ȥ�������ж�
						line = line.substring(index + word.length());
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return counter;
	}
	
	/**
	 * �鿴�ļ������ļ���
	 */
	public static void filelist(){
		File file = new File("D:/images");
		for(File temp : file.listFiles()){
			System.out.println("�ļ����� " + temp.getName());
		}
	}
	
	public static void readfile() {
		StringBuffer sb = new StringBuffer();
		String read = null;
		File f = new File("C:\\Users\\ɽ����\\Desktop\\Test2.txt");
		try {
			FileInputStream fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			while((read = br.readLine()) != null) {
				sb.append(read);
			}
			System.out.println(sb);
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void countfile() throws Exception {
		File file = new File("C:\\Users\\ɽ����\\Desktop\\Test2.txt");
		InputStream is = new FileInputStream(file);
		byte b[] = new byte[1024];
		int a = is.read(b);
		String str[] = new String(b, 0, a).split("");
		int count = 0;
		for(int i = 0; i < str.length; i++) {
			System.out.print(str[i]);
			if ("a".equals(str[i])) {
				count++;
			}
		}
		System.out.println(str);
		is.close();
	}
	
	public static void getFile() throws IOException {
		StringBuilder sb = new StringBuilder("this is new string");
		sb.replace(0, sb.length(), "this is number 123");
		FileInputStream fis = new FileInputStream(new File("D:\\images\\001.jpg"));
		System.out.println(sb + "\n" +fis);
		fis.close();
	}
	
	
	public static void main(String[] args) throws Exception {
		File_StringUtil.getFile();
	}
}
