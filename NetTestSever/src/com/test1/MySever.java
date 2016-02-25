/*
 * 网络编程测试，服务器端，在4000端口监听客户端（client）发来的消息
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
			//设置端口监听
			ServerSocket ss = new ServerSocket(4000);
			System.out.println("在此阻塞等待");
			//等待客户端来连接，会返回一个socket连接,在此阻塞、等待
			Socket s = ss.accept();
			System.out.println("客户端已连接");
			
			//要读取数据需要用到
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			
			String duru = br.readLine();
			
			System.out.println("服务器收到："+duru);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
