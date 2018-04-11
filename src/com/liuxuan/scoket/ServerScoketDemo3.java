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
 * 基于TCP协议的scoket通信，实现用户登录，服务端
 * @author 山贝戊
 *
 */
public class ServerScoketDemo3 {
	static ServerSocket serverSocket;
	/**
	 * 服务器端：
                 ① 创建ServerSocket对象，绑定监听端口
                 ② 通过accept()方法监听客户端请求
                 ③ 连接建立后，通过输入流读取客户端发送的请求信息
                 ④ 通过输出流向客户端发送乡音信息
                 ⑤ 关闭相关资源
	 */
	public static void main(String[] args) {
        InputStreamReader isr;
        BufferedReader br;
        OutputStreamWriter osw;
        BufferedWriter bw;
        String str;
        Scanner in = new Scanner(System.in);
        try {
            ServerSocket server = new ServerSocket(10086);// 在本机的4444端口开放Server

            Socket socket = server.accept();// 只要产生连接，socket便可以代表所连接的那个物体，同时这个server.accept()只有产生了连接才会进行下一步操作。
            System.out.println(socket.getInetAddress());// 输出连接者的IP。
            System.out.println("建立了一个连接！");
            while (true) {
                isr = new InputStreamReader(socket.getInputStream());
                br = new BufferedReader(isr);
                System.out.println(socket.getInetAddress() + ":" + br.readLine());
                osw = new OutputStreamWriter(socket.getOutputStream());
                bw = new BufferedWriter(osw);
                System.out.print("服务端回复:");
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
