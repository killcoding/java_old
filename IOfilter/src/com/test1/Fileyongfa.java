/*
 * file��Ļ����÷�
 */
package com.test1;

import java.io.*;

public class Fileyongfa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//����һ���ļ�����
//		File f = new File("e:/11.txt");
//		//�õ��ļ���·��
//		System.out.println("�ļ�·��"+f.getPath());
//		//�õ��ļ��Ĵ�С
//		System.out.println("�ļ���С"+f.length());
		//�����ļ�
//		File f = new File("e:\\22.txt");
//		if(!f.exists())
//		{
//			//����
//			try {
//				f.createNewFile();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}else{
//			System.out.println("�����ļ�");
//		}
		//�����ļ���
//		File f = new File("e:\\sd");
//		if(f.isDirectory())
//		{
//			System.out.println("�ļ�����");
//		}else{
//			f.mkdir();
//		}
		//�г��ļ��µ��ļ�
		File f = new File("e:\\demo");
		if(f.isDirectory())
		{
			File list[] = f.listFiles();
			for(int i=0;i<list.length;i++)
			{
				System.out.println("�ļ���"+list[i].getName());
			}
		}
	}

}
