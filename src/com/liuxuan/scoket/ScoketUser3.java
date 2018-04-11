package com.liuxuan.scoket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * �ͻ���
 * @author ɽ����
 *
 */
public class ScoketUser3 {
	/**
	 * �ͻ��ˣ�
                 �� ����Socket����ָ����Ҫ���ӵķ������ĵ�ַ�Ͷ˿ں�
                 �� ���ӽ�����ͨ���������������˷���������Ϣ
                 �� ͨ����������ȡ��������Ӧ����Ϣ
                 �� �ر���Ӧ��Դ
	 */
	public static void main(String[] args) {
        InputStreamReader isr;
        BufferedReader br;
        OutputStreamWriter osw;
        BufferedWriter bw;
        String str;
        Scanner in = new Scanner(System.in);
        try {
            Socket socket = new Socket("localhost", 10086);
//          System.out.println(socket.getInetAddress());// ��������ߵ�IP��
            System.out.println("�ɹ����ӷ�����");
            while (true) {
                osw = new OutputStreamWriter(socket.getOutputStream());
                bw = new BufferedWriter(osw);
                System.out.print("�ͻ��˻ظ�:");
                str = in.nextLine();
                bw.write(str + "\n");
                bw.flush();

                isr = new InputStreamReader(socket.getInputStream());
                br = new BufferedReader(isr);
                System.out.println(socket.getInetAddress() + ":" + br.readLine());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
