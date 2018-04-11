package com.liuxuan.file_string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class File_StringUtil {
	
	private File_StringUtil(){
		throw new AssertionError();
	}
	
	/**
	 * ͳ�Ƹ����ļ��и����ַ����ĳ��ִ���
	 * @param filename
	 * @param word
	 * @return
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
	
	
	public static void main(String[] args) {
		File_StringUtil.filelist();
	}
}
