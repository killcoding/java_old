
/*
 * һЩswing���ʹ�ã�����һ����½��
 * �õ�����ǩJLable���ı���LTextField�������JPasswordField
 */
package com.swing;
import java.awt.*;
import javax.swing.*;

public class Test extends JFrame {

	//�������
	JPanel jp1,jp2,jp3;		//	
	JLabel jl1,jl2;			//��ǩ���
	JButton jb1,jb2;	//��ť���
	JTextField jt1;		//�ı������
	JPasswordField jps;
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
		jp3 = new JPanel();
		jl1 = new JLabel("�û���");
		jl2 = new JLabel("��    ��");
		jb1 = new JButton("��½");
		jb2 = new JButton("ȡ��");
		jt1 = new JTextField(10);
		jps = new JPasswordField(10);
		
		//���ò��ֹ�����
		this.setLayout(new GridLayout(3,1));
		
		//����������
		jp1.add(jl1);
		jp1.add(jt1);
		jp2.add(jl2);
		jp2.add(jps);
		jp3.add(jb1);
		jp3.add(jb2);
		
		//�����������뵽JFrame
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		//���ô���
		this.setTitle("��½����");
		this.setSize(300, 200);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��ʾ
		this.setVisible(true);
	}

}
