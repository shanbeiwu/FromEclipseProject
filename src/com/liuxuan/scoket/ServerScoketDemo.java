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
 * 基于TCP协议的scoket通信，实现用户登录，服务端
 * @author 山贝戊
 *
 */
public class ServerScoketDemo {
	static ServerSocket serverSocket;
	/**
	 * 服务器端：
                 ① 创建ServerSocket对象，绑定监听端口
                 ② 通过accept()方法监听客户端请求
                 ③ 连接建立后，通过输入流读取客户端发送的请求信息
                 ④ 通过输出流向客户端发送乡音信息
                 ⑤ 关闭相关资源
	 */
	public static void serverScoketfun(){
		try {
			
			//1.创建一个服务器端Socket，即serversocket，指定绑定的接口，并监听此接口
			serverSocket = new ServerSocket(10086);
			
			System.out.println("创建成功，如下信息");
			System.out.println(serverSocket.getLocalPort());
			System.out.println(serverSocket.getLocalSocketAddress());
			System.out.println(serverSocket.getInetAddress());
			System.out.println(serverSocket.toString());
			System.out.println("信息结束");
			
			//2.调用accept()方法开始监听，等待客户端的链接
			Socket socket = serverSocket.accept();
			
			
			
			//3.获取输入流，并获取客户端信息
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String info = null;
			System.out.println(br.toString());
			while((info = br.readLine()) != null){
				System.out.println("我是服务器，客户端说: "+info);
			}
			socket.shutdownInput();//关闭输入流
			
			//4.获取输出流，相应客户端的请求
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("你好啊！！");
			pw.flush();
			
			//5.关闭资源
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
