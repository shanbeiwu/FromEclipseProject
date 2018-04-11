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
	 * InetAddress�����ڱ�ʶ�����ϵ�Ӳ����Դ����ʶ������Э��(IP)��ַ�� 
	 * ����û�й��췽��
	 * @author ɽ����
	 *
	 */
	public static void inetaddress() {
		//��ȡ������InetAddrressʵ��
		try {
			InetAddress inetaddress = InetAddress.getLocalHost();
			String hostname = inetaddress.getHostName();//��ȡ�������
			String hostaddress = inetaddress.getHostAddress();//��ȡIP��ַ
			byte[] bytes = inetaddress.getAddress();//��ȡ�ֽ�������ʽ��IP��ַ,�Ե�ָ����Ĳ���
			System.out.println("hostname: "+hostname+" hostaddress: "+hostaddress);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * URL(Uniform Resource Locator)ͳһ��Դ��λ������ʾInternet��ĳһ��Դ�ĵ�ַ��Э��������Դ����
	 * @author ɽ����
	 */
	public static void URLfunction(){
		try {
			URL urlbaidu = new URL("https://www.baidu.com");
			URL url = new URL(urlbaidu, "/index.html?username=tom#test");//����ʾ������#��ʾê��
			System.out.println("��ȡЭ��: "+url.getProtocol());//��ȡЭ��
			System.out.println("��ȡ����: "+url.getHost());//��ȡ����
			System.out.println("�˿ں�: "+url.getPort());//���û��ָ���˿ںţ�����Э�鲻ͬʹ��Ĭ�϶˿ڡ���ʱgetPort()�����ķ���ֵΪ -1
			System.out.println("��ȡ�ļ�·��: "+url.getPath());//��ȡ�ļ�·��
			System.out.println("��ȡ�ļ���: "+url.getFile());//��ȡ�ļ����������ļ�·��+����
			System.out.println("��ȡ���·��: "+url.getRef());//��ȡ���·��������ê�㣬��#�ź��������
			System.out.println("��ѯ����: "+url.getQuery());//��ѯ�ַ�����������
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ʹ��URL��ȡ��ҳ����
     * ͨ��URL�����openStream()�������Եõ�ָ����Դ����������ͨ�����ܹ���ȡ�������ҳ�ϵ���Դ  
     * @author ɽ����
	 */
	public static void URLReadHTML(){
		// TODO ʹ��url��ȡ��ҳ����
		try {
			URL url = new URL("https://www.baidu.com");//����һ��url����
			InputStream is = url.openStream();//ͨ��OPENSTREAM������ȡ��Դ���ֽ�������
			InputStreamReader isr = new InputStreamReader(is,"utf-8");//���ֽ�������ת��Ϊ�ַ�����������ָ�����뷽ʽ����ֹ��������
			BufferedReader br = new BufferedReader(isr);//Ϊ�ַ���������ӻ��壬��߶�ȡЧ��
			String data = br.readLine();//��ȡ����
			while(data != null){
				System.out.println(data+"\n");//�������
				data = br.readLine();//��Ӷ�ȡ��һ����Ϊ�˷�ֹ�ظ���ȡ��һ�У��ڶ����һ�к��ȡ��һ��
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
