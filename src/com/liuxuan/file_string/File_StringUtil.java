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
	 * 统计给定文件中给定字符串的出现次数
	 * @param filename
	 * @param word
	 * @return
	 */
	
	public static int countWordInFile(String filename, String word){
		int counter = 0;
		//打开文件流，打开文件
		try(FileReader fr = new FileReader(filename)){
			//创建使用默认大小的输入缓冲区的缓冲字符输入流
			try(BufferedReader br = new BufferedReader(fr)){
				String line = null;
				//判断line与文件每行内容是否为null
				while((line = br.readLine()) != null){
					int index = -1;
					//判断每一行的长度是或否大于或等于文字的长度&&文字在每一行出现的索引值大于或等于0
					while((line.length() >= word.length() && (index = line.indexOf(word)) >= 0)){
						counter++;
						//在这里截取line将出现的文字去掉重新判断
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
	 * 查看文件夹下文件名
	 */
	public static void filelist(){
		File file = new File("D:/images");
		for(File temp : file.listFiles()){
			System.out.println("文件名： " + temp.getName());
		}
	}
	
	
	public static void main(String[] args) {
		File_StringUtil.filelist();
	}
}
