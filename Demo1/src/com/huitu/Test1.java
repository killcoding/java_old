/*
 * java��ͼԭ��
 * ��jpanel�ϻ�
 * ������󻯣���С��ʱpaint���Զ�����
 * 
 */
package com.huitu;

import javax.swing.*;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import java.awt.*;
public class Test1 extends JFrame {

	MyPanel mp=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test1 test1 = new Test1();
	}
	public Test1()
	{
		mp = new MyPanel();
		
		this.add(mp);
		this.setSize(200,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

}

//�����Լ���panel��(�Լ�����壬���Լ���ͼ������)
/*class MyPanel extends JPanel
{
	//����JPANEL�е�paint����
	public void paint(Graphics g)//gtaphics�ǻ��� �ǻ�ͼ����Ҫ��
	{
		//���ø�����ɳ�ʼ��
		//��仰����ʡ
		System.out.println("������paint");
		super.paint(g);
		//�Ȼ�һ����
		//g.drawOval(10, 10, 30, 30);
		//��ֱ��
		//g.drawLine(10, 10, 30, 10);
		//�����б߿�
		//g.drawRect(10, 10, 40, 40);
		//��������
		//���þ�����ɫ
//		g.setColor(Color.blue);
//		g.fillRect(10, 10, 30, 20);
//		g.setColor(Color.red);
//		g.fillRect(50, 60, 30, 20);
		//����ͼƬ
//		Image im = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/keai.jpg"));
//		
//		g.drawImage(im, 10,10, 800, 600, this);
		//���ַ���
//		g.setColor(Color.red);//��Ҫ��д����Ǯ����
//		g.setFont(new Font("���Ĳ���",Font.BOLD,50));
//		g.drawString("�ַ�����ʾ", 100, 100);
		
		
		
		
	}
}*/
