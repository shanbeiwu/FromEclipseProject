package com.liuxuan.scoket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �ͻ���
 * @author ɽ����
 *
 */
public class ScoketUser {
	/**
	 * �ͻ��ˣ�
                 �� ����Socket����ָ����Ҫ���ӵķ������ĵ�ַ�Ͷ˿ں�
                 �� ���ӽ�����ͨ���������������˷���������Ϣ
                 �� ͨ����������ȡ��������Ӧ����Ϣ
                 �� �ر���Ӧ��Դ
	 */
	public static void adminScoket(){
		try {
			//1.����socket�ͻ��ˣ�ָ����������ַ�Ͷ˿�
			Socket socket = new Socket("localhost", 10086);
			
			System.out.println(socket.getRemoteSocketAddress());
			System.out.println(socket.getInetAddress());
			
//			//2.��ȡ��������������������Ϣ
//			OutputStream os = socket.getOutputStream();//�ֽ������
//			PrintWriter pw = new PrintWriter(os);//���������װ�Ǵ�ӡ��
//			pw.write("�û�����admin;���룺123");
//			pw.flush();
//			
//			//3.��ȡ������������ȡ�������˵���Ӧ��Ϣ
//			InputStream is = socket.getInputStream();
//			
//			BufferedReader br = new BufferedReader(new InputStreamReader(is));
//			String info = null;
//			
//			System.out.println("is: " + is.available());
//			System.out.println("br: " + br.ready());
//			
//			while((info = br.readLine()) != null){
//				System.out.println("���ǿͻ��ˣ�������˵��" + info);
//			}
//			
//			//4.�ر���Դ
//			br.close();
//			is.close();
//			pw.close();
//			os.close();
//			socket.close();
			
			
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			PrintWriter pw = new PrintWriter(os);
			pw.print("hello");
			pw.flush();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String str = br.readLine();
			System.out.println("-->" + str);
			
			is.close();
			os.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		adminScoket();
	}
}
