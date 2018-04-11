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
 * @author ɽ����
 *	��������ļ��ĸ��ƣ��ṩ�������Ƶķ���
 *	@date 2-24_A
 *  �������еķ������Ǿ�̬��ʽ���ʵ���˽�������˽�в�����������(���Ժ�ϰ��)
 */
public final class CopyFile {
	
	private CopyFile(){
		throw new AssertionError();
	}
	
	/**
	 * �����ļ�����һ
	 * @param source
	 * @param target
	 * @throws IOException
	 */
	public static void fileCopy(String source, String target) throws IOException {
		//ͨ������ʵ���ļ�������source������һ���ļ� ���ļ���·������source
		try (InputStream in = new FileInputStream(source)) {
			//�����ļ��������ָ��������д���ļ�
			try(OutputStream out = new FileOutputStream(target)){
				byte[] buffer = new byte[4096];
				int  bytesToRead;
				//�Ӹ���������ȡ���buffer.length�ֽڵ����ݵ��ֽ����飬�˷������ܻ����������ֱ��ĳЩ�������
				while((bytesToRead = in.read(buffer)) != -1){
					//��λ��ƫ���� 0 ��ָ���ֽ�����д��bytesToRead���ȵ��ֽڵ����ļ������
					out.write(buffer, 0, bytesToRead);
				}
			}
		}
	}
	
	/**
	 * �����ļ�������
	 * @param source
	 * @param target
	 * @throws IOException
	 */
	public static void fileCopyNIO(String source, String target) throws IOException{
		try(FileInputStream in = new FileInputStream(source)){
			try(FileOutputStream out = new FileOutputStream(target)){
				//��������ļ�������������Ψһ��filechannel����
				FileChannel inChannel = in.getChannel();
				FileChannel outChannel = out.getChannel();
				//����һ������Ϊ4096�ֽڵ��ֽڻ�����
				ByteBuffer buffer = ByteBuffer.allocate(4096);
				//�Ӹ�ͨ����ȡ�������������ֽ����У���ȡ���ֽ���������Ϊ�㣬���ͨ���Ѵﵽ����ĩβ����Ϊ-1
				while(inChannel.read(buffer) != -1){
					//��תbuffer����������ͨ����ȡ����ò�������֮�󣬵��ô˷�����׼��һϵ��ͨ��д�����Ի�ȡ�Ĳ���
					buffer.flip();
					//�Ӹ����Ļ��������ͨ��д��һϵ���ֽ�
					outChannel.write(buffer);
					//�������������ʹ��һϵ��ͨ����ȡ����ò������˻�����֮ǰ���ô˷���
					buffer.clear();
				}
			}
		}
	}
	
}
