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
			String s = "�������";
			//�����ֽ�����
//			byte []bytes = new byte[1024];
			//��Stringת����һ��byte������
			
			fos.write(s.getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			fos.close();
		}
		
		
	}

}
