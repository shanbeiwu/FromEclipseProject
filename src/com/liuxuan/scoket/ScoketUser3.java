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
 * 客户端
 * @author 山贝戊
 *
 */
public class ScoketUser3 {
	/**
	 * 客户端：
                 ① 创建Socket对象，指明需要连接的服务器的地址和端口号
                 ② 连接建立后，通过输出流想服务器端发送请求信息
                 ③ 通过输入流获取服务器响应的信息
                 ④ 关闭响应资源
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
//          System.out.println(socket.getInetAddress());// 输出连接者的IP。
            System.out.println("成功连接服务器");
            while (true) {
                osw = new OutputStreamWriter(socket.getOutputStream());
                bw = new BufferedWriter(osw);
                System.out.print("客户端回复:");
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
