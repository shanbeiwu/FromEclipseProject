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
public class ServerScoketDemo2 {
	/** 
	   * @param args 
	   * @throws IOException 
	   * @throws UnknownHostException 
	   */
	  public static void main(String[] args) throws Exception, IOException { 
	    //客户端发数据到服务端 
	    /* 
	     * Tcp传输，客户端建立的过程。 
	     * 1，创建tcp客户端socket服务。使用的是Socket对象。 
	     *   建议该对象一创建就明确目的地。要连接的主机。 
	     * 2，如果连接建立成功，说明数据传输通道已建立。 
	     *   该通道就是socket流 ,是底层建立好的。 既然是流，说明这里既有输入，又有输出。 
	     *   想要输入或者输出流对象，可以找Socket来获取。 
	     *   可以通过getOutputStream(),和getInputStream()来获取两个字节流。 
	     * 3，使用输出流，将数据写出。 
	     * 4，关闭资源。 
	     */
	    //创建客户端socket服务。 
	    //连接目标服务器的地址，192.168.1.100是目标服务器的地址，10086是目标服务器的端口 
	    Socket socket = new Socket("localhost",10086); 
	    //获取socket流中的输出流。 向服务器输出消息，即发消息到服务器 
	    OutputStream out = socket.getOutputStream(); 
	    //使用输出流将指定的数据写出去。 
	    out.write("tcp演示：我又来了!".getBytes()); 
	    
	    //获取服务端发送的消息
//	    InputStream is = socket.getInputStream();
//	    BufferedReader br = new BufferedReader(new InputStreamReader(is));
//	    String str = br.readLine();
//	    System.out.println(str);
	    
	    
	    //关闭资源。 
//	    br.close();
//	    is.close();
	    out.close();
	    socket.close(); 
	  } 
}
