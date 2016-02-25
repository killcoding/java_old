/**
 * 测试的客户端程序，连接服务器
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
			//用于连接某个服务器端，参数为服务器的ip和端口号
			Socket s = new Socket("127.0.0.1",4000);
			//如果连接成功就可以发数据给服务器
			//通过pw向s输入数据，true表示及时刷新
			PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
			pw.println("客户端发送");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
