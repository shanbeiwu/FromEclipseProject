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
public class ServerScoketDemo2 {
	/** 
	   * @param args 
	   * @throws IOException 
	   * @throws UnknownHostException 
	   */
	  public static void main(String[] args) throws Exception, IOException { 
	    //�ͻ��˷����ݵ������ 
	    /* 
	     * Tcp���䣬�ͻ��˽����Ĺ��̡� 
	     * 1������tcp�ͻ���socket����ʹ�õ���Socket���� 
	     *   ����ö���һ��������ȷĿ�ĵء�Ҫ���ӵ������� 
	     * 2��������ӽ����ɹ���˵�����ݴ���ͨ���ѽ����� 
	     *   ��ͨ������socket�� ,�ǵײ㽨���õġ� ��Ȼ������˵������������룬��������� 
	     *   ��Ҫ���������������󣬿�����Socket����ȡ�� 
	     *   ����ͨ��getOutputStream(),��getInputStream()����ȡ�����ֽ����� 
	     * 3��ʹ���������������д���� 
	     * 4���ر���Դ�� 
	     */
	    //�����ͻ���socket���� 
	    //����Ŀ��������ĵ�ַ��192.168.1.100��Ŀ��������ĵ�ַ��10086��Ŀ��������Ķ˿� 
	    Socket socket = new Socket("localhost",10086); 
	    //��ȡsocket���е�������� ������������Ϣ��������Ϣ�������� 
	    OutputStream out = socket.getOutputStream(); 
	    //ʹ���������ָ��������д��ȥ�� 
	    out.write("tcp��ʾ����������!".getBytes()); 
	    
	    //��ȡ����˷��͵���Ϣ
//	    InputStream is = socket.getInputStream();
//	    BufferedReader br = new BufferedReader(new InputStreamReader(is));
//	    String str = br.readLine();
//	    System.out.println(str);
	    
	    
	    //�ر���Դ�� 
//	    br.close();
//	    is.close();
	    out.close();
	    socket.close(); 
	  } 
}
