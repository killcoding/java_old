/*
 * �¼��������,����ί���¼�ģ��
 * ��ʱʹ��JPanel�ı�����ɫ������ʾ��������
 * ע�⣺������Ҫ��ע�ᣬ
 * ��jb1.addActionListener(this);//���¼�Դ����Ӽ�����
 * ������Ϊ�������¼�������ֻ࣬�м�������Ż���ܵ��¼�Դ������ʱ�䴦������
 */
package com.jiantingjizhi;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;//�¼������
public class Test1 extends JFrame implements ActionListener{

	/**
	 * @param args
	 */
	JPanel mp = new JPanel();
	JButton jb1 = null;
	JButton jb2 = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test1  test1 = new Test1();
	}
	
	public Test1()
	{
		mp = new JPanel();
		jb1 = new JButton("��ɫ");
		
		jb2 = new JButton("��ɫ");
		
		this.add(jb1,BorderLayout.NORTH);
		this.add(mp);
		this.add(jb2,BorderLayout.SOUTH);
		
		//ע�����
		jb1.addActionListener(this);//���¼�Դ����Ӽ�����
		//�ƶ�action����
		jb1.setActionCommand("��ɫ");
		
		jb2.addActionListener(this);
		jb2.setActionCommand("��ɫ");
		
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}

	@Override
	//���¼�����ķ���
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//�ж����ĸ��¼�Դ����
		if(e.getActionCommand().equals("��ɫ"))
		{
			System.out.println("���º�ɫ");
			mp.setBackground(Color.black);
		}else if(e.getActionCommand().equals("��ɫ"))
		{
			System.out.println("���º�ɫ");
			mp.setBackground(Color.red);
		}
	}

}

//class MyPanel extends JPanel
//{
//	public void paint(Graphics g)
//	{
//		super.paint(g);
//		
//		
//	
//	}
//}