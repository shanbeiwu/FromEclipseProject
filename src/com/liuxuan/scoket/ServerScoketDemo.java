package com.liuxuan.scoket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����TCPЭ���scoketͨ�ţ�ʵ���û���¼�������
 * @author ɽ����
 *
 */
public class ServerScoketDemo {
	static ServerSocket serverSocket;
	/**
	 * �������ˣ�
                 �� ����ServerSocket���󣬰󶨼����˿�
                 �� ͨ��accept()���������ͻ�������
                 �� ���ӽ�����ͨ����������ȡ�ͻ��˷��͵�������Ϣ
                 �� ͨ���������ͻ��˷���������Ϣ
                 �� �ر������Դ
	 */
	public static void serverScoketfun(){
		try {
			
			//1.����һ����������Socket����serversocket��ָ���󶨵Ľӿڣ��������˽ӿ�
			serverSocket = new ServerSocket(10086);
			
			System.out.println("�����ɹ���������Ϣ");
			System.out.println(serverSocket.getLocalPort());
			System.out.println(serverSocket.getLocalSocketAddress());
			System.out.println(serverSocket.getInetAddress());
			System.out.println(serverSocket.toString());
			System.out.println("��Ϣ����");
			
			//2.����accept()������ʼ�������ȴ��ͻ��˵�����
			Socket socket = serverSocket.accept();
			
			
			
			//3.��ȡ������������ȡ�ͻ�����Ϣ
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String info = null;
			System.out.println(br.toString());
			while((info = br.readLine()) != null){
				System.out.println("���Ƿ��������ͻ���˵: "+info);
			}
			socket.shutdownInput();//�ر�������
			
			//4.��ȡ���������Ӧ�ͻ��˵�����
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("��ð�����");
			pw.flush();
			
			//5.�ر���Դ
			pw.close();
			os.close();
			br.close();
			isr.close();
			is.close();
			socket.close();
			serverSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		serverScoketfun();
	}
}
