/*
 * file类的基本用法
 */
package com.test1;

import java.io.*;

public class Fileyongfa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//创建一个文件对象
//		File f = new File("e:/11.txt");
//		//得到文件的路径
//		System.out.println("文件路径"+f.getPath());
//		//得到文件的大小
//		System.out.println("文件大小"+f.length());
		//创建文件
//		File f = new File("e:\\22.txt");
//		if(!f.exists())
//		{
//			//创建
//			try {
//				f.createNewFile();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}else{
//			System.out.println("存在文件");
//		}
		//创建文件夹
//		File f = new File("e:\\sd");
//		if(f.isDirectory())
//		{
//			System.out.println("文件存在");
//		}else{
//			f.mkdir();
//		}
		//列出文件下的文件
		File f = new File("e:\\demo");
		if(f.isDirectory())
		{
			File list[] = f.listFiles();
			for(int i=0;i<list.length;i++)
			{
				System.out.println("文件名"+list[i].getName());
			}
		}
	}

}
