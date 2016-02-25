/*
 * file文件流的操作
 */
package com.wenjianliu;
import java.io.*;
public class test {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File f = new File("e:\\test.txt");
		FileInputStream fis = null;
		//file没有读写的功能，所以需要使用inputstream流
		try {
			
			fis = new FileInputStream(f);
			
			//定义一个字节数组
			byte []bytes = new byte[1024];
			int n=0;//得到事迹读取到的字节数
			//循环读取
			while((n=fis.read(bytes))!=-1)
			{
				//把字节转换成字符
				String s = new String(bytes,0,n);
				System.out.println(s);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//不管程序是否出现异常，必须执行的程序块，关闭文件流
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
