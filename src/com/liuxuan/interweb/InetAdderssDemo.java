package com.liuxuan.interweb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;



public class InetAdderssDemo {
	
	public static void main(String[] args) {
		InetAdderssDemo.inetaddress();
		InetAdderssDemo.URLfunction();
		InetAdderssDemo.URLReadHTML();
	}
	
	/**
	 * InetAddress类用于标识网络上的硬件资源，标识互联网协议(IP)地址。 
	 * 该类没有构造方法
	 * @author 山贝戊
	 *
	 */
	public static void inetaddress() {
		//获取本机的InetAddrress实例
		try {
			InetAddress inetaddress = InetAddress.getLocalHost();
			String hostname = inetaddress.getHostName();//获取计算机名
			String hostaddress = inetaddress.getHostAddress();//获取IP地址
			byte[] bytes = inetaddress.getAddress();//获取字节数组形式的IP地址,以点分隔的四部分
			System.out.println("hostname: "+hostname+" hostaddress: "+hostaddress);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * URL(Uniform Resource Locator)统一资源定位符，表示Internet上某一资源的地址，协议名：资源名称
	 * @author 山贝戊
	 */
	public static void URLfunction(){
		try {
			URL urlbaidu = new URL("https://www.baidu.com");
			URL url = new URL(urlbaidu, "/index.html?username=tom#test");//？表示参数，#表示锚点
			System.out.println("获取协议: "+url.getProtocol());//获取协议
			System.out.println("获取主机: "+url.getHost());//获取主机
			System.out.println("端口号: "+url.getPort());//如果没有指定端口号，根据协议不同使用默认端口。此时getPort()方法的返回值为 -1
			System.out.println("获取文件路径: "+url.getPath());//获取文件路径
			System.out.println("获取文件名: "+url.getFile());//获取文件名，包括文件路径+参数
			System.out.println("获取相对路径: "+url.getRef());//获取相对路径，就是锚点，即#号后面的内容
			System.out.println("查询参数: "+url.getQuery());//查询字符串，即参数
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用URL读取网页内容
     * 通过URL对象的openStream()方法可以得到指定资源的输入流，通过流能够读取或访问网页上的资源  
     * @author 山贝戊
	 */
	public static void URLReadHTML(){
		// TODO 使用url读取网页内容
		try {
			URL url = new URL("https://www.baidu.com");//创建一个url对象
			InputStream is = url.openStream();//通过OPENSTREAM方法获取资源的字节输入流
			InputStreamReader isr = new InputStreamReader(is,"utf-8");//将字节输入流转换为字符输入流，并指定编码方式，防止出现乱码
			BufferedReader br = new BufferedReader(isr);//为字符输入流添加缓冲，提高读取效率
			String data = br.readLine();//读取数据
			while(data != null){
				System.out.println(data+"\n");//输出数据
				data = br.readLine();//添加读取下一行是为了防止重复读取第一行，在读完第一行后读取下一行
			}
			br.close();
			isr.close();
			is.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
