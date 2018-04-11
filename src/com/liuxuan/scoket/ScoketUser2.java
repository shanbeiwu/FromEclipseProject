package com.liuxuan.scoket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �ͻ���
 * @author ɽ����
 *
 */
public class ScoketUser2 {
	//UDP:���Ͷˡ����ն� (������) 
	  //TCP:�ͻ��ˡ������ (Ҫ����)����������ˣ��������ͻ��� 
	  /** 
	   * @param args 
	   * @throws IOException 
	   */
	  public static void main(String[] args) throws IOException { 
	   //����˽��տͻ��˷��͹��������ݣ�����ӡ�ڿ���̨�ϡ�  
	    /* 
	     * ����tcp����˵�˼·�� 
	     * 1�����������socket����ͨ��ServerSocket���� 
	     * 2������˱�������ṩһ���˿ڣ�����ͻ����޷����ӡ� 
	     * 3����ȡ���ӹ����Ŀͻ��˶��� 
	     * 4��ͨ���ͻ��˶����ȡsocket����ȡ�ͻ��˷��������� 
	     *   ����ӡ�ڿ���̨�ϡ� 
	     * 5���ر���Դ���ؿͻ��ˣ��ط���ˡ� 
	     */
	    //1��������˶��� 
	    ServerSocket serversocket = new ServerSocket(10086);
	    //����Ӧ�����ڷ�������10002�˿ڣ�
	    //����û�пͻ������ӹ��������߷�����Ϣ 
	    //2,��ȡ���ӹ����Ŀͻ��˶��� 
	    Socket socket = serversocket.accept();//����ʽ. 
	    String ip = socket.getInetAddress().getHostAddress();
	    //��ȡ���ӹ����ͻ��˵�IP��ַ 
	    
	  //���Ϳͻ��˶�ȡ����Ϣ
	    OutputStream os = socket.getOutputStream();
	    os.write("���ǿͻ���".getBytes());
	    
	    //3��ͨ��socket�����ȡ��������Ҫ��ȡ�ͻ��˷��������ݣ� 
	    InputStream in = socket.getInputStream();
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    String str = br.readLine();
	    System.out.println("�ͻ�˵�� " + str);
	    
	    
	    
	    
	    
	    br.close();
	    socket.close(); 
	    serversocket.close();//�رշ��������������ǲ��ùص� 
	  } 
}
