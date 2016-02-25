package com.shuchuliu;
import java.io.*;

public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File f =new File("e:\\22.txt");
		FileOutputStream fos=null;
		try {
			fos = new FileOutputStream(f);
			String s = "测试输出";
			//定义字节数组
//			byte []bytes = new byte[1024];
			//把String转换成一个byte的数组
			
			fos.write(s.getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			fos.close();
		}
		
		
	}

}
