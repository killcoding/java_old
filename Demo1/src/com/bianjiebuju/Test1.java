/**
 * BorderLayout��ʾ���߽粼����ʾ��
 * 1.�̳�JFrame
 * 2.�������
 * 3.������������캯���ڲ���
 * 4.���������Ѵ�������������ӵ�������Ӧ�ô��ڵ�λ�ã�
 * 5.�Զ��������Ĵ����������
 * 6.��ʾ����
 */

package com.bianjiebuju;

import java.awt.*;
import javax.swing.*;

public class Test1 extends JFrame {

	//�������,5����ť���
	JButton jb1,jb2,jb3,jb4,jb5;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test1 test1 = new Test1();
	}
	
	//�������캯��
	public Test1()
	{
		//�������
		jb1 = new JButton("�в�");
		jb2 = new JButton("����");
		jb3 = new JButton("�ϲ�");
		jb4 = new JButton("����");
		jb5 = new JButton("����");
		
		//��Ӹ������������̳���JFrame������this
		this.add(jb1, BorderLayout.CENTER);
		this.add(jb2, BorderLayout.NORTH);
		this.add(jb3, BorderLayout.SOUTH);
		this.add(jb4, BorderLayout.EAST);
		this.add(jb5, BorderLayout.WEST);
		
		//���ô�������
		this.setTitle("�߽粼�ַ���");				//���ô������
		this.setSize(300, 200);		//���ô�С
		this.setLocation(200, 200);//���ô��������Ļ���Ͻǵ�λ��
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����˳�ʱ�رմ���
		
		//��ʾ����
		this.setVisible(true);//ʵ�ִ������ʾ
		
	}

}
