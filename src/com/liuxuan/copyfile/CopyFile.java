package com.liuxuan.copyfile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 
 * @author 山贝戊
 *	此类完成文件的复制，提供两个复制的方法
 *	@date 2-24_A
 *  工具类中的方法都是静态方式访问的因此将构造器私有不允许创建对象(绝对好习惯)
 */
public final class CopyFile {
	
	private CopyFile(){
		throw new AssertionError();
	}
	
	/**
	 * 复制文件方法一
	 * @param source
	 * @param target
	 * @throws IOException
	 */
	public static void fileCopy(String source, String target) throws IOException {
		//通过打开与实际文件的链接source来创建一个文件 该文件的路径就是source
		try (InputStream in = new FileInputStream(source)) {
			//创建文件输出流以指定的名称写入文件
			try(OutputStream out = new FileOutputStream(target)){
				byte[] buffer = new byte[4096];
				int  bytesToRead;
				//从该输入流读取最多buffer.length字节的数据到字节数组，此方法可能会造成阻塞，直到某些输入可用
				while((bytesToRead = in.read(buffer)) != -1){
					//从位于偏移量 0 的指定字节数组写入bytesToRead长度的字节到该文件输出流
					out.write(buffer, 0, bytesToRead);
				}
			}
		}
	}
	
	/**
	 * 复制文件方法二
	 * @param source
	 * @param target
	 * @throws IOException
	 */
	public static void fileCopyNIO(String source, String target) throws IOException{
		try(FileInputStream in = new FileInputStream(source)){
			try(FileOutputStream out = new FileOutputStream(target)){
				//返回与此文件输出流相关联的唯一的filechannel对象
				FileChannel inChannel = in.getChannel();
				FileChannel outChannel = out.getChannel();
				//创建一个容量为4096字节的字节缓冲区
				ByteBuffer buffer = ByteBuffer.allocate(4096);
				//从该通道读取给定缓冲区的字节序列，读取的字节数，可能为零，如果通道已达到流出末尾，则为-1
				while(inChannel.read(buffer) != -1){
					//翻转buffer缓冲区，在通道读取或放置操作序列之后，调用此方法来准备一系列通道写入或相对获取的操作
					buffer.flip();
					//从给定的缓冲区向该通道写入一系列字节
					outChannel.write(buffer);
					//清除缓冲区，在使用一系列通道读取或放置操作填充此缓冲区之前调用此方法
					buffer.clear();
				}
			}
		}
	}
	
}
