package com.edvor.writedata;
import jxl.*;
import java.io.*;
import jxl.write.*;
public class WriteData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			//���ļ�
			WritableWorkbook book=
			Workbook.createWorkbook(new File("E:/���ݴ洢/����.xls"));
			//������Ϊ����һҳ���Ĺ���������0��ʾ���ǵ�һҳ
			WritableSheet sheet=book.createSheet("��һҳ",0);
			//��Label����Ĺ�������ָ����Ԫ��λ���ǵ�һ�е�һ��(0,0)
			//�Լ���Ԫ������Ϊtest
			Label label=new Label(0,0,"test");
			//������õĵ�Ԫ����ӵ���������
			sheet.addCell(label);
			/*����һ���������ֵĵ�Ԫ��
			����ʹ��Number��������·�����������﷨����
			��Ԫ��λ���ǵڶ��У���һ�У�ֵΪ789.123*/
			jxl.write.Number number = new jxl.write.Number(1,0,789.123);
			sheet.addCell(number);
			//д�����ݲ��ر��ļ�
			book.write();
			book.close();
			System.out.println("ִ�����");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	

}
