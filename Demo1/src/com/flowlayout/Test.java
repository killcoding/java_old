/**
 * ��ʽ���ַ�����ϰ��FlowLayout��
 * ��ʽ����Ĭ���Ǿ��ж����,�����ڲ��ֹ����������ö��뷽ʽ
 */
package com.flowlayout;

import java.awt.*;

import javax.swing.*;

public class Test extends JFrame{

	//������Ҫ�����
	JButton jb1,jb2,jb3,jb4,jb5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test test = new Test();
	}
	//�������캯��
	public Test()
	{
		//�������
		jb1 = new JButton("��ť1");
		jb2 = new JButton("��ť2");
		jb3 = new JButton("��ť3");
		jb4 = new JButton("��ť4");
		jb5 = new JButton("��ť5");
		
		//������
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		
		//���ò��ֹ�����
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//���ô�������
		this.setTitle("��ʽ���ַ���");				//���ô������
		this.setSize(300, 200);		//���ô�С
		this.setLocation(200, 200);//���ô��������Ļ���Ͻǵ�λ��
		//��ֹ�û��ı䴰�ڴ�С
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����˳�ʱ�رմ���
				
		//��ʾ����
		this.setVisible(true);//ʵ�ִ������ʾ
		
	}

}
