/*
 * file�ļ����Ĳ���
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
		//fileû�ж�д�Ĺ��ܣ�������Ҫʹ��inputstream��
		try {
			
			fis = new FileInputStream(f);
			
			//����һ���ֽ�����
			byte []bytes = new byte[1024];
			int n=0;//�õ��¼���ȡ�����ֽ���
			//ѭ����ȡ
			while((n=fis.read(bytes))!=-1)
			{
				//���ֽ�ת�����ַ�
				String s = new String(bytes,0,n);
				System.out.println(s);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//���ܳ����Ƿ�����쳣������ִ�еĳ���飬�ر��ļ���
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
