package com.liuxuan.scoket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * ����TCPЭ���scoketͨ�ţ�ʵ���û���¼�������
 * @author ɽ����
 *
 */
public class ServerScoketDemo3 {
	static ServerSocket serverSocket;
	/**
	 * �������ˣ�
                 �� ����ServerSocket���󣬰󶨼����˿�
                 �� ͨ��accept()���������ͻ�������
                 �� ���ӽ�����ͨ����������ȡ�ͻ��˷��͵�������Ϣ
                 �� ͨ���������ͻ��˷���������Ϣ
                 �� �ر������Դ
	 */
	public static void main(String[] args) {
        InputStreamReader isr;
        BufferedReader br;
        OutputStreamWriter osw;
        BufferedWriter bw;
        String str;
        Scanner in = new Scanner(System.in);
        try {
            ServerSocket server = new ServerSocket(10086);// �ڱ�����4444�˿ڿ���Server

            Socket socket = server.accept();// ֻҪ�������ӣ�socket����Դ��������ӵ��Ǹ����壬ͬʱ���server.accept()ֻ�в��������ӲŻ������һ��������
            System.out.println(socket.getInetAddress());// ��������ߵ�IP��
            System.out.println("������һ�����ӣ�");
            while (true) {
                isr = new InputStreamReader(socket.getInputStream());
                br = new BufferedReader(isr);
                System.out.println(socket.getInetAddress() + ":" + br.readLine());
                osw = new OutputStreamWriter(socket.getOutputStream());
                bw = new BufferedWriter(osw);
                System.out.print("����˻ظ�:");
                str = in.nextLine();
                bw.write(str + "\n");
                bw.flush();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
