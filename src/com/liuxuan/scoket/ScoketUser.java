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
 * 客户端
 * @author 山贝戊
 *
 */
public class ScoketUser {
	/**
	 * 客户端：
                 ① 创建Socket对象，指明需要连接的服务器的地址和端口号
                 ② 连接建立后，通过输出流想服务器端发送请求信息
                 ③ 通过输入流获取服务器响应的信息
                 ④ 关闭响应资源
	 */
	public static void adminScoket(){
		try {
			//1.创建socket客户端，指定服务器地址和端口
			Socket socket = new Socket("localhost", 10086);
			
			System.out.println(socket.getRemoteSocketAddress());
			System.out.println(socket.getInetAddress());
			
//			//2.获取输出流，向服务器发送信息
//			OutputStream os = socket.getOutputStream();//字节输出流
//			PrintWriter pw = new PrintWriter(os);//将输出流包装城打印流
//			pw.write("用户名：admin;密码：123");
//			pw.flush();
//			
//			//3.获取输入流，并读取服务器端的相应信息
//			InputStream is = socket.getInputStream();
//			
//			BufferedReader br = new BufferedReader(new InputStreamReader(is));
//			String info = null;
//			
//			System.out.println("is: " + is.available());
//			System.out.println("br: " + br.ready());
//			
//			while((info = br.readLine()) != null){
//				System.out.println("我是客户端，服务器说：" + info);
//			}
//			
//			//4.关闭资源
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
