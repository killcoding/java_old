/**
 * ���ԵĿͻ��˳������ӷ�����
 */
package com.test;

import java.io.*;
import java.net.*;


public class MyClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClient mc = new MyClient();
	}
	
	public MyClient()
	{
		try {
			//��������ĳ���������ˣ�����Ϊ��������ip�Ͷ˿ں�
			Socket s = new Socket("127.0.0.1",4000);
			//������ӳɹ��Ϳ��Է����ݸ�������
			//ͨ��pw��s�������ݣ�true��ʾ��ʱˢ��
			PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
			pw.println("�ͻ��˷���");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
