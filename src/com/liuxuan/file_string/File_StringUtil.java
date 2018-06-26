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
	 * 统计给定文件中给定字符串的出现次数
	 * @param filename(统计文件)
	 * @param word(所需要匹配的字段)
	 * @return counter(出现的测次数)
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
	
	public static void readfile() {
		StringBuffer sb = new StringBuffer();
		String read = null;
		File f = new File("C:\\Users\\山贝戊\\Desktop\\Test2.txt");
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
		File file = new File("C:\\Users\\山贝戊\\Desktop\\Test2.txt");
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
