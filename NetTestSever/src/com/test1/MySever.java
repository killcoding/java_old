/*
 * �����̲��ԣ��������ˣ���4000�˿ڼ����ͻ��ˣ�client����������Ϣ
 * 
 * */

package com.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class MySever {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MySever ms = new MySever();
		
	}
	
	public MySever()
	{
		try {
			//���ö˿ڼ���
			ServerSocket ss = new ServerSocket(4000);
			System.out.println("�ڴ������ȴ�");
			//�ȴ��ͻ��������ӣ��᷵��һ��socket����,�ڴ��������ȴ�
			Socket s = ss.accept();
			System.out.println("�ͻ���������");
			
			//Ҫ��ȡ������Ҫ�õ�
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			
			String duru = br.readLine();
			
			System.out.println("�������յ���"+duru);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
