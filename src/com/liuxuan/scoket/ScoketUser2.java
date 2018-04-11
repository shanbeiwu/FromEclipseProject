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
 * 客户端
 * @author 山贝戊
 *
 */
public class ScoketUser2 {
	//UDP:发送端、接收端 (无连接) 
	  //TCP:客户端、服务端 (要连接)先启动服务端，在启动客户端 
	  /** 
	   * @param args 
	   * @throws IOException 
	   */
	  public static void main(String[] args) throws IOException { 
	   //服务端接收客户端发送过来的数据，并打印在控制台上。  
	    /* 
	     * 建立tcp服务端的思路： 
	     * 1，创建服务端socket服务。通过ServerSocket对象。 
	     * 2，服务端必须对外提供一个端口，否则客户端无法连接。 
	     * 3，获取连接过来的客户端对象。 
	     * 4，通过客户端对象获取socket流读取客户端发来的数据 
	     *   并打印在控制台上。 
	     * 5，关闭资源。关客户端，关服务端。 
	     */
	    //1创建服务端对象。 
	    ServerSocket serversocket = new ServerSocket(10086);
	    //监听应用所在服务器的10002端口，
	    //看有没有客户端连接过来，或者发送消息 
	    //2,获取连接过来的客户端对象。 
	    Socket socket = serversocket.accept();//阻塞式. 
	    String ip = socket.getInetAddress().getHostAddress();
	    //获取连接过来客户端的IP地址 
	    
	  //发送客户端读取的消息
	    OutputStream os = socket.getOutputStream();
	    os.write("我是客户端".getBytes());
	    
	    //3，通过socket对象获取输入流，要读取客户端发来的数据， 
	    InputStream in = socket.getInputStream();
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    String str = br.readLine();
	    System.out.println("客户说： " + str);
	    
	    
	    
	    
	    
	    br.close();
	    socket.close(); 
	    serversocket.close();//关闭服务器，理论上是不用关的 
	  } 
}
