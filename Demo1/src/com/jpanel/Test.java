/*
 * ���ֲ��ֹ�������ʹ��
 * JPanel����Ĭ����FlowLayout
 */

package com.jpanel;
import java.awt.*;
import javax.swing.*;

public class Test extends JFrame{

	//������Ҫ�����
	JPanel jp1,jp2;
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test test = new Test();
	}

	//���캯��
	public Test()
	{
		//�������
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		jb1 = new JButton("��ť1");
		jb2 = new JButton("��ť2");
		jb3 = new JButton("��ť3");
		jb4 = new JButton("��ť4");
		jb5 = new JButton("��ť5");
		jb6 = new JButton("��ť6");
		
		//���ò��֣�JFrameĬ���Ǳ߽粼��
		
		//������,��ӵ�panel
		jp1.add(jb1);
		jp1.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
		
		//��panel��ӵ�jfeame
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.SOUTH);
		this.add(jb6,BorderLayout.CENTER);
		
		//���ô���
		this.setTitle("���ֲ��ֹ�����ʹ��");
		this.setSize(300,300);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��ʾ����
		this.setVisible(true);
	}
}
